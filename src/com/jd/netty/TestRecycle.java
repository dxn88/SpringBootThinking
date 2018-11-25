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

    public static void main(String[] args) {

        User user = userRecycler.get();
        user.setName("dxn");
        System.out.println("user = " + user);
        user.setName(null);
        user.recycle();

        User user2 = userRecycler.get();
        System.out.println("user2 = " + user2);

        Assert.isTrue(user == user2, "对象不相等！");

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
