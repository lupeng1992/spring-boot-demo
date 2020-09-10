package com.example.demo.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.example.demo.entity.User;

public class SystemContext {

    private final static ThreadLocal<User> personModelStore = new TransmittableThreadLocal<User>();


    /**
     * 取得当前线程的User Model
     *
     * @return
     */
    public static User getCurrentPerson()
    {
        return personModelStore.get();
    }

    /**
     * 设置当前线程的User Model
     *
     * @param user
     */
    public static void setCurrentPerson(User user)
    {
        personModelStore.set(user);
    }

    /**
     * 清除当前线程的User Model
     */
    public static void clearCurrentPerson()
    {
        personModelStore.remove();
    }
}
