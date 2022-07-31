package com.scaler.model.player;


import com.scaler.model.Board;
import com.scaler.model.CellSymbol;
import com.scaler.model.Game;
import com.scaler.playStrategy.PlayingStrategy;
import com.scaler.playStrategy.PlayingStrategyFactory;

public class Bot extends Player {

    Level level;
    PlayingStrategy playingStrategy;

    public Bot(Level l, CellSymbol c){
        super(c);
        this.level = l;
        this.playingStrategy = PlayingStrategyFactory.getPlayingStrategy(l);
    }

    @Override
    public void playMove(Game g) {
        playingStrategy.playMove(g.getBoard(), playerSymbol);
    }
}
