package render;

import utils.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StartFrame extends JFrame {
    private JPanel bannerPanel;
    private JPanel buttonsPanel;

    private JLabel bannerLabel;

    public StartFrame(){
        super("checkers-java");
        try{
            Image image = FileUtils.loadImage("checkers.png");
            if(image != null) this.setIconImage(image);
        }catch (IOException e){
            System.out.println("Failed to load StartFrame icon");
        }
    }

    public void loadFrame() {
        // Initialize Panels
        initializeBannerPanel();
        initializeButtonsPanel();

        // Add panels
        this.setLayout(new BorderLayout());
        this.add(this.bannerPanel, BorderLayout.NORTH);
        this.add(this.buttonsPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void initializeBannerPanel(){
        this.bannerLabel = new JLabel("Checkers"); // "<html><font color=white size=33>Checkers</font></html>"
        this.bannerLabel.setVerticalTextPosition(JLabel.BOTTOM);
        this.bannerLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.bannerLabel.setFont(new Font("Serif", Font.BOLD, 33));
        this.bannerLabel.setForeground(new Color(211, 211, 211));
        ImageIcon imageIcon = FileUtils.loadImageIcon("checkers.png");
        if(imageIcon != null) this.bannerLabel.setIcon(imageIcon);

        this.bannerPanel = new JPanel();
        this.bannerPanel.add(bannerLabel, BorderLayout.NORTH);
        this.bannerPanel.setPreferredSize(new Dimension(600, 200));
        this.bannerPanel.setBackground(new Color(21, 21, 21, 255));
    }

    private void initializeButtonsPanel(){


        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setPreferredSize(new Dimension(200, 500));
        this.buttonsPanel.setBackground(new Color(33, 33, 33, 255));
    }
}
