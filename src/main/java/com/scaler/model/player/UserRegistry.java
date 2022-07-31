package com.scaler.model.player;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRegistry {
    private static Map<Integer, HumanUser> userRegister;
    private static AtomicInteger userCounter;
    static{
        userCounter = new AtomicInteger();
        userRegister = new HashMap<>();
        userCounter.set(0);
    }
    public static void registerUser(String name, byte[] photo) {
        final int id = userCounter.incrementAndGet();
        HumanUser user = new HumanUser(name, photo, id);
        userRegister.put(id, user);
    }
    public static void removeUser(int id){
        userRegister.remove(id);
    }
    public static HumanUser getUser(int id){
        return userRegister.get(id);
    }
    public static void updateUser(int id, String name, byte[] photo){
        HumanUser user = getUser(id);
        user.setUserName(name);
        user.setPhoto(photo);
    }
}
