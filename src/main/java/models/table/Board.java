package models.table;

import java.awt.*;
import java.io.Serializable;
import java.util.Arrays;

public class Board implements BoardI, Serializable {
    private final int SIZE = 8;
    private SlotI[][] table;

    public Board(){
        this.initializeBoard();
    }

    public Board(SlotI[][] table) {
        this.setTable(table);
    }

    public Board(Board board){
        this.table = board.getTable();
    }

    private void initializeBoard(){
        this.table = new SlotI[this.SIZE][this.SIZE];
        int color = 1;
        int piece = -1;
        for (int i = 0; i < this.SIZE; i++) {
            int crtColor = color;
            for (int j = 0; j < this.SIZE; j++) {
                if(crtColor == 0 && i > 4) piece = 0;
                else if(crtColor == 0 && i < 3) piece = 1;
                this.table[i][j] = new Slot(new Point(i, j), crtColor, piece);
                crtColor = crtColor == 0 ? 1 : 0;
                piece = -1;
            }
            color = color == 0 ? 1 : 0;
        }
    }

    public SlotI getSlot(int x, int y){
        if(this.table == null || this.table[x][y] ==  null) return null;
        return this.table[x][y].clone();
    }

    public void setSlot(int x, int y, SlotI slot){
        if(this.table == null) return;
        this.table[x][y] = slot.clone();
    }

    public int getSize() {
        return this.SIZE;
    }

    public SlotI[][] getTable() {
        SlotI[][] newTable = new SlotI[this.SIZE][this.SIZE];
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                SlotI crt = this.table[i][j];
                if(crt != null) newTable[i][j] = crt.clone();
            }
        }
        return newTable;
    }

    public void setTable(SlotI[][] table) {
        SlotI[][] newTable = new SlotI[this.SIZE][this.SIZE];
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
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
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
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
