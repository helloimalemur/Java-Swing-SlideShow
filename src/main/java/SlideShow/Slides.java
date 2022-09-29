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
    public Label overlaylabel = new Label();
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
    public void cycleImages(String[] pathlist) { /**/
        System.out.println("Starting.."); /**/
        int index = 0;
        while (index < pathlist.length) { /**/
            if (back && !(index<1)) { //back on b key //boolean set by keylistener
                index = index - 2; //increments down twice to get last image
                back = false;
            } //back when pressing "b" key



//            if (pause) { //if pause is false //pause when pressing "p" key //boolean set by keylistener
//                index--; //increments i down to stay on current image
//            }

            if (next) {
                index++;
                next = false;
            }

            //update image
            if (!pause) {
                setImage(pathlist, index);
                index++;
            }
            sleeper();
        }
        cycleImages(pathlist);
    }

    public void overlay(String overlaystring, long overlaylong) {
        try {
            panel.remove(overlaylabel);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        overlaylabel.setText(overlaystring + String.valueOf(overlaylong));
        overlaylabel.setSize(300,100);
        overlaylabel.setLocation(0,0);

        overlaylabel.setBackground(Color.black);
        overlaylabel.setForeground(Color.white);
        try {
            panel.add(overlaylabel);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        overlaylabel.setVisible(true);
        try {
            Thread.sleep(1000);
            panel.remove(overlaylabel);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        overlaylabel.setVisible(false);
    }

    public void clearImages() {
        panel.removeAll();
    }
}
