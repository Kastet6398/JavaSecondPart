package tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tools {
    private Tools() {
        throw new IllegalStateException("Utility class is not initialized");
    }
    public static List<BufferedImage> images = new ArrayList<>();
    static {
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("zombie-1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        myPicture = Tools.convertToBufferedImage(myPicture.getScaledInstance(myPicture.getWidth() * 3, myPicture.getHeight() * 3, Image.SCALE_SMOOTH));
        images.add(myPicture);

        BufferedImage myPicture2;
        try {
            myPicture2 = ImageIO.read(new File("zombie-2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        myPicture2 = Tools.convertToBufferedImage(myPicture2.getScaledInstance(myPicture2.getWidth() * 3, myPicture2.getHeight() * 3, Image.SCALE_SMOOTH));
        images.add(myPicture2);
    }
    public static BufferedImage convertToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
