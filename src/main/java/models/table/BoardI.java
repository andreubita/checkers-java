package models.table;

public interface BoardI {
    SlotI getSlot(int x, int y);
    void setSlot(int x, int y, SlotI slot);
    public int getSize();
    SlotI[][] getTable();
    void setTable(SlotI[][] table);
    Board clone();
    boolean equals(Object o);
    int hashCode();
    String toString();
}
