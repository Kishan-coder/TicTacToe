package com.scaler;

import java.util.Random;

public class MyRandom {
    static Random random;
    static{
        random = new Random();
    }
    public static Random getInstance(){
        return random;
    }
}
