package models.table;

import java.awt.*;

public interface SlotI {
    Point getPosition();
    void setPosition(Point position);
    int getColor();
    void setColor(int color);
    int getPiece();
    void setPiece(int piece);
    Slot clone();
    boolean equals(Object o);
    int hashCode();
    String toString();
}
