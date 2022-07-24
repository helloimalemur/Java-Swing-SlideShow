import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Slides {
    public boolean pause = false;
    public boolean waspaused = false;
    public boolean back = false;
    public String[] listofimages = new String[0];
    public JPanel panel = new JPanel(new FlowLayout());
    public org.imgscalr.Scalr scalr = new Scalr();
    public long slideinterval;


    public void loadImageGlob() { //load images into String []
        FileContentReader fcr = new FileContentReader(null); // path to images
        System.out.println("grabImages\n");
        listofimages = fcr.getFiles(); // String []
    }

    //scaler
    public BufferedImage scaleImage(BufferedImage resizeMe) {
        //BufferedImage resizeMe = ImageIO.read(new File("orig.jpg"));
        Dimension newMaxSize = new Dimension(SlideShow.device.getDisplayMode().getWidth()-20, SlideShow.device.getDisplayMode().getHeight()-20);
        return scalr.resize(resizeMe, Scalr.Mode.FIT_TO_HEIGHT,
                newMaxSize.width, newMaxSize.height);
    }

    //
    public void setImage(String[] imagepaths, int i) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(imagepaths[i]));
            System.out.println(imagepaths[i]);
            Image image = scaleImage(bufferedImage); //scale image
            JLabel pic = new JLabel(new ImageIcon(image));
            Dimension dimension = new Dimension(SlideShow.device.getDisplayMode().getWidth(), SlideShow.device.getDisplayMode().getHeight());
            panel.setSize(dimension);
            panel.setBackground(Color.BLACK);
            panel.add(pic);
            pic.setSize(SlideShow.device.getDisplayMode().getWidth(), SlideShow.device.getDisplayMode().getHeight());
            //pic.setSize(panel.getSize());
            pic.setVisible(true);
            panel.setVisible(true);
            panel.updateUI();
            try {
                Thread.sleep(slideinterval);
            } catch (Exception exception) {
                System.out.println(exception);
            }
            panel.remove(pic);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public void cycleImages(String[] pathlist) { /**/
        System.out.println("Starting.."); /**/
        for (int i = 0; i < pathlist.length; i++) { /**/
            if (back) { //back on b key //boolean set by keylistener
                if (i > 0) {
                    i = i - 2; //increments down twice to get last image
                    pause = false;
                    back = false;
                }
            } //back when pressing "b" key

            if (i < 0) {i++;} // don't let back set i less than 0

            if (!pause) { //pause when pressing "p" key //boolean set by keylistener
                setImage(pathlist, i);
                if (waspaused) {pause = true;} // if going back when paused, stay paused
            } else {
                i--; //increments i down to stay on current image
                waspaused = true;
            }
        }
    }

    public void clearImages() {
        panel.removeAll();
    }
}
