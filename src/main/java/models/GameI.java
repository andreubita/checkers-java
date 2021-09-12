package models;

import models.table.BoardI;

public interface GameI {
    BoardI getBoard();
    void setBoard(BoardI board);
    Game clone();
    boolean equals(Object o);
    int hashCode();
    String toString();
}
