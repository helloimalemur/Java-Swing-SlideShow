package SlideShow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Slides {
    public boolean pause = false;
    public boolean next = false;
    public boolean waspaused = false;
    public boolean back = false;
    public String[] listofimages = new String[0];
    public JPanel panel = new JPanel(new FlowLayout());

    public Scalr scalr = new Scalr();
    public long slideinterval;
    public String path;

    public Slides(String s) {
        path = s;
    }

    public void loadImageGlob() { //load images into String []
        FileContentReader fcr = new FileContentReader(path); // path to images
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
            panel.removeAll();
            BufferedImage bufferedImage = ImageIO.read(new File(imagepaths[i]));
            System.out.println(imagepaths[i]);
            Image image = scaleImage(bufferedImage); //scale image
            JLabel pic = new JLabel(new ImageIcon(image));
            Dimension dimension = new Dimension(SlideShow.device.getDisplayMode().getWidth(), SlideShow.device.getDisplayMode().getHeight());
            panel.setSize(dimension);
            panel.setBackground(Color.BLACK);
            pic.setSize(SlideShow.device.getDisplayMode().getWidth(), SlideShow.device.getDisplayMode().getHeight());
            panel.add(pic);
            pic.setBackground(Color.black);
            pic.setVisible(true);
            panel.setVisible(true);
            panel.updateUI();
            //sleeper();
            //panel.remove(pic);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void sleeper() {
        try {
            Thread.sleep(slideinterval);
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    public void cycleImages(String[] pathlist) {
        System.out.println("Starting..");
        int index = 0;

        while (index < pathlist.length) {

            //back when pressing "b" key
            if (back && !(index<1)) { //back on b key //boolean set by keylistener
                index = index - 2; //increments down twice to get last image
                back = false;
            }

            //increment up for next image/skip
            if (next) {
                index++;
                next = false;
            }

            //update image if not paused
            if (!pause) {
                setImage(pathlist, index);
                index++;
            }

            //sleep for theshold
            sleeper();
        }
        cycleImages(pathlist);
    }

    public void clearImages() {
        panel.removeAll();
    }
}
