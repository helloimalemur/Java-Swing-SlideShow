import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Slides {
    public String[] imageglob = new String[0];
    public String[] used = new String[0];
    public String[] usingimages = new String[0];
    public String[] usedimages = new String[0];
    public String[] previouslyusedimages = new String[0];
    public String[] images = new String[0];
    public String[] redunantimageglob = new String[0];
    public JPanel panel = new JPanel(new FlowLayout());
    public JLabel piclabel = new JLabel();
    public ImageIcon icon = new ImageIcon();


    public void runner() {
        System.out.println("starting slideshow");
        loadImages(genImageList());
    }
    public void loadImageGlob() {
        FileContentReader fcr = new FileContentReader(null);
        System.out.println("grabImages\n");
        imageglob = fcr.getFiles();
    }

    public String[] genImageList() {
        System.out.println("genlist\n");
        loadImageGlob();
        redunantimageglob = imageglob;
        previouslyusedimages = usingimages;
        Set<String> usedimagesset = new HashSet<>();
        Set<String> previouslyusedset = new HashSet<>(Arrays.asList(previouslyusedimages));
        Set<String> imageglobset = new HashSet<>(Arrays.asList(redunantimageglob));
        /*Set<String> usingset = new HashSet<>(Arrays.asList(usingimages));*/
        Set<String> usingset = new HashSet<>(Arrays.asList(imageglob));

        usedimagesset.addAll(previouslyusedset); /*add prev used to empty set*/
        usingset.removeAll(usedimagesset); /**/
        usingimages = new String[usingset.size()]; /**/
        usingset.toArray(usingimages); /**/
        return usingimages; /**/
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
                Image image = bufferedImage.getScaledInstance(100,100, 0);

                JLabel pic = new JLabel(new ImageIcon(image));
                //JLabel pic = new JLabel(new ImageIcon(bufferedImage));

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
