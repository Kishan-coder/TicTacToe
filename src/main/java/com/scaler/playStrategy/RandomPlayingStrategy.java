package com.scaler.playStrategy;

import com.scaler.MyRandom;
import com.scaler.model.Board;
import com.scaler.model.CellSymbol;

import java.util.Random;

public class RandomPlayingStrategy implements PlayingStrategy{
    static RandomPlayingStrategy RandomPlayingStrategy;

    static{
        RandomPlayingStrategy = new RandomPlayingStrategy();
    }

    public static RandomPlayingStrategy getRandomPlayingStrategy() {
        return RandomPlayingStrategy;
    }
    
    @Override
    public void playMove(Board b, CellSymbol symbol) {
        Random r = MyRandom.getInstance();
        int low = 0, high = b.getSize();
        int x = r.nextInt(high-low)+low,y = r.nextInt(high-low)+low;
        while (!b.isVacant( x, y)){
            x = r.nextInt(high-low)+low;
            y = r.nextInt(high-low)+low;
        }
        System.out.println(x + " " + y);
        b.placeSymbol(x, y, symbol);
    }

}
