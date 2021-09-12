import models.table.Board;
import models.table.Slot;
import models.table.SlotI;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testBoard(){
        SlotI[][] testTable = new SlotI[8][8];
        int color = 1;
        int piece = -1;
        for (int i = 0; i < 8; i++) {
            int crtColor = color;
            for (int j = 0; j < 8; j++) {
                if(crtColor == 0 && i > 4) piece = 0;
                else if(crtColor == 0 && i < 3) piece = 1;
                testTable[i][j] = new Slot(new Point(i, j), crtColor, piece);
                crtColor = crtColor == 0 ? 1 : 0;
                piece = -1;
            }
            color = color == 0 ? 1 : 0;
        }

        Board board = new Board();
        SlotI[][] crtBoard = board.getTable();
        for (int i = 0; i < 8; i++) {
            assertArrayEquals(crtBoard[i], testTable[i]);
        }
    }
}
