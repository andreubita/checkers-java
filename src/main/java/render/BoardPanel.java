package render;

import models.GameI;
import models.table.BoardI;
import models.table.SlotI;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    public static int SLOT_SIZE = 100;

    private GameI game;

    public BoardPanel(GameI game){
        this.game = game;
        super.setBackground(Color.LIGHT_GRAY);
        super.setPreferredSize(new Dimension(800, 800));
    }

    @Override
    public void paint(Graphics g) {
        BoardI board = game.getBoard();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                SlotI slot = board.getSlot(i, j);
                int piece = slot.getPiece();

                // Draw the actual Slot
                if(slot.getColor() == 0) g.setColor(Color.BLACK);
                else if(slot.getColor() == 1) g.setColor(Color.WHITE);
                else continue;
                g.fillRect(j * SLOT_SIZE, i * SLOT_SIZE, SLOT_SIZE, SLOT_SIZE);

                // Draw pieces
                if(piece == -1) continue;
//                g.setColor(Color.RED);
//                g.drawOval(j * SLOT_SIZE + SLOT_SIZE/4, i * SLOT_SIZE + SLOT_SIZE/4, SLOT_SIZE/2+15, SLOT_SIZE/2+15);
                if(piece == 0) g.setColor(Color.BLUE);
                else if(piece == 1) g.setColor(Color.RED);
                g.fillOval(j * SLOT_SIZE + SLOT_SIZE/4, i * SLOT_SIZE + SLOT_SIZE/4, SLOT_SIZE/2, SLOT_SIZE/2);
            }
        }
    }
}
