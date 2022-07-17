import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.desktop.ScreenSleepListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Slides {
    public String[] imageglob = new String[0];
    public JPanel panel = new JPanel(new FlowLayout());



    public void runner() {
        System.out.println("starting slideshow");
        loadImages(loadImageGlob());
    }
    public String[] loadImageGlob() { //load images into String []
        FileContentReader fcr = new FileContentReader(null); // path to images
        System.out.println("grabImages\n");
        imageglob = fcr.getFiles(); // String []
        return imageglob;
    }

    public void loadImages(String[] imagepaths) { /**/
        System.out.println("add images to caro"); /**/

        for (int i = 0; i < imagepaths.length; i++) { /**/
            /**/
             /**/

            try {
                BufferedImage bufferedImage = ImageIO.read(new File(imagepaths[i]));
                System.out.println(imagepaths[i]);
                //scale image
                Image image = bufferedImage.getScaledInstance(1000,1000, 0);

                JLabel pic = new JLabel(new ImageIcon(image));

                panel.add(pic);
                panel.setVisible(true);
                pic.setVisible(true);
                panel.updateUI();
                try {
                    Thread.sleep(5000);
                } catch(Exception exception) {
                    System.out.println(exception);
                }
                panel.remove(pic);



            } catch (IOException exception) {
                System.out.println(exception);
            }

        }
    }



    public void clearImages() {
        panel.removeAll();
    }
}
