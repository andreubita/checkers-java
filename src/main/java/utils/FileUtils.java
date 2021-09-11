package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static String RESOURCES_PATH = "src"       + File.separator
                                        + "main"      + File.separator
                                        + "resources" + File.separator;

    public static ImageIcon loadImageIcon(String path) {
        File file = new File(RESOURCES_PATH + path);
        if (!file.isFile() && file.exists() && file.getAbsoluteFile().getName().endsWith(".png"))
            return null;
        return new ImageIcon(file.getAbsolutePath());
    }

    public static Image loadImage(String path) throws IOException {
        File file = new File(RESOURCES_PATH + path);
        if(!file.isFile() && file.exists()) return null;
        return ImageIO.read(file);
    }
}
