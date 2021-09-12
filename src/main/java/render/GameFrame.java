package render;

import models.Game;
import models.GameI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    private final StartFrame startFrame;
    private BoardPanel boardPanel;
    private GameI game;

    public GameFrame(StartFrame startFrame){
        super("checkers-java");
        this.startFrame = startFrame;
        this.game = new Game();
        loadFrame();
    }

    public void loadFrame(){
        // Initialize Panels
        this.boardPanel = new BoardPanel(game);

        // Add panels
        super.setLayout(new BorderLayout());
        super.add(this.boardPanel, BorderLayout.NORTH);

        super.setPreferredSize(new Dimension(1000, 1000));
        super.pack();
        super.setVisible(true);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Close action
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                startFrame.setVisible(true);
            }
        });
    }

}
