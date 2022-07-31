package com.scaler.model.player;

import com.scaler.MyRandom;
import com.scaler.model.CellSymbol;
import com.scaler.model.Game;

import java.util.Random;
import java.util.Scanner;

public class HumanPlayer extends Player{
    HumanUser user;
    static Scanner s;
    static{
        s = new Scanner(System.in);
    }
    public HumanPlayer(HumanUser user, CellSymbol symbol){
        super(symbol);
        this.user= user;
    }
    @Override
    public void playMove(Game g) {
        Random r = MyRandom.getInstance();
        int x, y;
        while (true) {
            int rInt = r.nextInt(9);
            x = rInt / 3;
            y = rInt % 3;
            if (g.getBoard().isVacant(x, y))
                break;
        }
        System.out.println(x + " "+ y);
        g.getBoard().placeSymbol(x, y, playerSymbol);
    }
}
