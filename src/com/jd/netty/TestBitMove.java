package com.jd.netty;

/**
 * @author: <a href="mailto:daixunan@jd.com">戴续楠</a>
 * @date:2018/11/22
 */
public class TestBitMove {

    public int flag;

    public static void main(String[] args) {
        int status = 1 << 30;
        switch (status) {
            case Permission.CREATE:
                System.out.println("status = " + status);
                break;
            case Permission.FINISHED:
                System.out.println("status = " + status);
                break;
            default:
        }

        int permission = 1 << 3;

        if ((permission & Permission.OCRCHECKED) == 0) {
            System.out.println("permission = " + permission);
        }
    }


    public boolean hasPermission(int permission) {

        return (permission & flag) == 0;
    }


    public void enable(int permission) {
        flag |= permission; // 相当于flag = flag | permission;
    }

}

interface Permission{
    int CREATE = 1<<0;
    int SUBMIT = 1<<1;
    int TRANSLATING = 1<<2;
    int OCRCHECKED = 1<<3;
    int FINISHED = 1<<4;
}