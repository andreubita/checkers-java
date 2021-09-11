package models.table;

public interface BoardI {
    SlotI[][] getTable();
    void setTable(SlotI[][] table);
    Board clone();
    boolean equals(Object o);
    int hashCode();
    String toString();
}
