package com.scaler.model;

import java.util.ArrayList;
import java.util.List;

// we want new instance everytime as we want multiple players to play game in parallel
// otherwise if only one game allowed in a run then we can use singleton
public class Board {
    private List<List<CellSymbol>> square;
    void init(int n){
        square = new ArrayList<>();
        for (int i=0;i<n;i++){
            List<CellSymbol> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(CellSymbol.v);
            }
            square.add(row);
        }
    }
    public boolean isVacant(int x, int y){
        return square.get(x).get(y).equals(CellSymbol.v) ? true : false;
    }
    public void placeSymbol(int x, int y, CellSymbol symbol){
        square.get(x).set(y, symbol);
    }
    public int getSize(){
        return square.size();
    }
    public boolean isRowDone(){
        int j;
        for (int i=0;i<getSize();i++){
            CellSymbol cs1 = square.get(i).get(0);
            if (cs1 == CellSymbol.v)
                continue;
            for(j=1;j<getSize();j++){
                if (cs1 != square.get(i).get(j))
                    break;
            }
            if (j == getSize())
                return true;
        }
        return false;
    }
    public boolean isColumnDone(){
        int j;
        for (int i=0;i<getSize();i++){
            CellSymbol cs1 = square.get(0).get(i);
            if (cs1 == CellSymbol.v)
                continue;
            for(j=1;j<getSize();j++){
                if (cs1 != square.get(j).get(i))
                    break;
            }
            if (j == getSize())
                return true;
        }
        return false;
    }
    public boolean isDiagonalDone(){
        CellSymbol c1 = square.get(0).get(0),
                c2 = square.get(0).get(getSize()-1);
        boolean flag1 = true, flag2 = true;
        for(int i=1;i<getSize();i++){
            if (c1 != square.get(i).get(i))
                flag1 = false;
            if (c2 != square.get(i).get(getSize()-i-1))
                flag2 = false;
        }
        return (flag1==true && c1 != CellSymbol.v) || (flag2==true  && c2 != CellSymbol.v) ? true : false;
    }
}
