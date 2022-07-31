package com.scaler.model.player;

import com.scaler.model.CellSymbol;
import com.scaler.model.Game;

public abstract class  Player {

    CellSymbol playerSymbol;

    public CellSymbol getPlayerSymbol() {
        return playerSymbol;
    }

    public Player(CellSymbol c){
        playerSymbol = c;
    }

    public abstract void playMove(Game g);
}
