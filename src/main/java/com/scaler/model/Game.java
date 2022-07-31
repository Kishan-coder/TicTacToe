package com.scaler.model;

import com.scaler.MyRandom;
import com.scaler.model.player.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    private Board board;

    public Board getBoard() {
        return board;
    }

    public Game(){
        players= new ArrayList<>();
        board= new Board();
    }
    public void start(int n, PlayerType p1, PlayerType p2, Level l, int ... userId){
        if (n < 2)
            throw new IndexOutOfBoundsException("Size should be at-least 2!");
        board.init(n);
        initPlayers(p1, p2, l, userId);
    }
    private void initPlayers(PlayerType p1, PlayerType p2, Level l, int ... userId){
        Random r = MyRandom.getInstance();
        CellSymbol p1Symbol, p2Symbol;
        p1Symbol = r.nextInt(2) == 1 ? CellSymbol.x : CellSymbol.o;
        p2Symbol = p1Symbol.equals(CellSymbol.x) ? CellSymbol.o : CellSymbol.x;
        if (p1.equals(PlayerType.human))
            players.add(new HumanPlayer(UserRegistry.getUser(userId[0]), p1Symbol));
        else
            players.add(new Bot(l, p1Symbol));
        if (p2.equals(PlayerType.human) && p1.equals(PlayerType.computer))
            players.add(new HumanPlayer(UserRegistry.getUser(userId[0]), p2Symbol));
        else if (p2.equals(PlayerType.human) && p2.equals(PlayerType.human))
            players.add(new HumanPlayer(UserRegistry.getUser(userId[1]), p2Symbol));
        else
            players.add(new Bot(l, p1Symbol));
    }

    public boolean isOver(){
        if (board.isColumnDone())
            return true;
        if (board.isDiagonalDone())
            return true;
        if (board.isRowDone())
            return true;
        return false;
    }

}
