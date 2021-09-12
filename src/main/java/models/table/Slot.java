package models.table;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

public class Slot implements SlotI, Serializable {
    private Point position;
    private int color; // -1 - Clear; 0 - Black; 1 - White
    private int piece; // -1 - Empty; 0 - Blue; 1 - Red

    public Slot(){
        this.position = null;
        this.color = -1;
        this.piece = -1;
    }

    public Slot(Point position, int color, int piece) {
        this.position = position.getLocation();
        this.color = color;
        this.piece = piece;
    }

    public Slot(Slot slot){
        this.position = slot.getPosition();
        this.color = slot.getColor();
        this.piece = slot.getPiece();
    }

    public Point getPosition() {
        return this.position.getLocation();
    }

    public void setPosition(Point position) {
        this.position = position.getLocation();
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPiece() {
        return this.piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    @Override
    public Slot clone(){
        return new Slot(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return this.color == slot.getColor() &&
               this.piece == slot.getPiece() &&
               Objects.equals(position, slot.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, color, piece);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Slot{");
        sb.append("position=").append(position);
        sb.append(", color=").append(color);
        sb.append(", piece=").append(piece);
        sb.append('}');
        return sb.toString();
    }
}
