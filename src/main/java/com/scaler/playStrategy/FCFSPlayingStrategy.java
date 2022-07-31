package com.scaler.playStrategy;

import com.scaler.model.Board;
import com.scaler.model.CellSymbol;

public class FCFSPlayingStrategy implements PlayingStrategy {
    static FCFSPlayingStrategy fcfsPlayingStrategy;
    static {
        fcfsPlayingStrategy = new FCFSPlayingStrategy();
    }
    public static FCFSPlayingStrategy getFcfsPlayingStrategy() {
        return fcfsPlayingStrategy;
    }

    @Override
    public void playMove(Board b, CellSymbol c) {
        for (int i = 0; i < b.getSize(); i++)
            for (int j = 0; j < b.getSize(); j++)
                if (b.isVacant(i, j)) {
                    b.placeSymbol(i, j, c);
                    System.out.println(i + " "+ j);
                    return;
                }
    }

}
