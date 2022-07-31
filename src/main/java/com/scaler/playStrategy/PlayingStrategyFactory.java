package com.scaler.playStrategy;

import com.scaler.model.player.Level;

public class PlayingStrategyFactory {

    public static PlayingStrategy getPlayingStrategy(Level l) {
        if (l.equals(Level.easy))
            return FCFSPlayingStrategy.getFcfsPlayingStrategy();
        else if (l.equals(Level.medium))
            return RandomPlayingStrategy.getRandomPlayingStrategy();
        return null;
    }
}
