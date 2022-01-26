package ver3;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    private static BufferedImage[][][] playerImages;

    static void initImages() {
        BufferedImage[][][] images = new BufferedImage[5][2][8];
        try {
            for (int i = 0; i < 5; i++) {
                images[i][0][0] = ImageIO.read(new File("Assets/Images/Player.png")).getSubimage(0, 30 * i, 42, 30);
            }
            for (int i = 0;i<5;i++) {
                for (int j = 0; j < 8; j++) {
                    images[i][1][j] = ImageIO.read(new File("Assets/Images/PlayerMoving.png")).getSubimage(j*42,i*30,42,30);

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        playerImages = images;
    }


    public static BufferedImage[][][] getPlayerImages() {
        return playerImages;
    }

}