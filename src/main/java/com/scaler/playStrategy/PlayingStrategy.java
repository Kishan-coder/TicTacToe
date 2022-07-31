package com.scaler.playStrategy;

import com.scaler.model.Board;
import com.scaler.model.CellSymbol;

public interface PlayingStrategy {
    void playMove(Board board, CellSymbol symbol);
}
