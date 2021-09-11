package models.table;

import java.io.Serializable;
import java.util.Arrays;

public class Board implements BoardI, Serializable {
    public static int SIZE = 8;
    private SlotI[][] table;

    public Board(){
        this.table = new SlotI[SIZE][SIZE];
    }

    public Board(SlotI[][] table) {
        this.table = table;
    }

    public Board(Board board){
        this.table = board.getTable();
    }

    public SlotI[][] getTable() {
        SlotI[][] newTable = new SlotI[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                SlotI crt = this.table[i][j];
                if(crt != null) newTable[i][j] = crt.clone();
            }
        }
        return newTable;
    }

    public void setTable(SlotI[][] table) {
        SlotI[][] newTable = new SlotI[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                SlotI crt = table[i][j];
                if(crt != null) newTable[i][j] = crt.clone();
            }
        }
        this.table = newTable;
    }

    public Board clone(){
        return new Board(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.deepEquals(this.table, board.getTable());
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(this.table);
    }

    @Override
    public String toString() {
        if(this.table == null) return "Table is null.";
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                SlotI crt = this.table[i][j];
                String print = "  ";
                if(crt != null){
                    if(crt.getColor() == 0) print = "X ";
                    else if(crt.getColor() == 1) print = "O ";
                }
                sb.append(print);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
