package com.jd.netty;

import io.netty.util.Recycler;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.Assert;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/25
 */
public class TestRecycle {

    public static void main(String[] args) throws InterruptedException {

        User user = userRecycler.get();
        user.setName("dxn");
        System.out.println("user = " + user);
        user.setName(null);
        user.recycle();

        User user2 = userRecycler.get();
        System.out.println("user2 = " + user2);

        Assert.isTrue(user == user2, "对象不相等！");

//////////////////////////// 异步回收对象
        // 1、从回收池获取对象
        User user1 = userRecycler.get();
        // 2、设置对象并使用
        user1.setName("hello,java");

        Thread thread = new Thread(()->{
            System.out.println(user1);
            // 3、对象恢复出厂设置
            user1.setName(null);
            // 4、回收对象到对象池
            user1.recycle();
        });

        thread.start();
        thread.join();

        // 5、从回收池获取对象
        User user3 = userRecycler.get();
//        Assert.assertSame(user1, user2);

    }

    private static final Recycler<User> userRecycler = new Recycler<User>() {
        @Override
        protected User newObject(Handle<User> handle) {
            return new User(handle);
        }
    };

@Data
@ToString
static final class User {
    private String name;
    private Recycler.Handle<User> handle;

    public User(Recycler.Handle<User> handle) {
        this.handle = handle;
    }

    public void recycle() {
        handle.recycle(this);
    }
    }

}
