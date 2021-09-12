package models;

import models.table.Board;
import models.table.BoardI;

import java.util.Objects;

public class Game implements GameI {
     private BoardI board;

     public Game(){
         this.board = new Board();
     }

     public Game(Game game){
         this.board = game.getBoard();
     }

    public BoardI getBoard() {
        return this.board.clone();
    }

    public void setBoard(BoardI board) {
        this.board = board.clone();
    }

    public Game clone(){
         return new Game(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(this.board, game.getBoard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(board);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Game{");
        sb.append("board=").append(board);
        sb.append('}');
        return sb.toString();
    }
}
