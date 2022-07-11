import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

class SlideShow extends JFrame {
    public static String[] used = new String[0];
    public static String[] usingimages = new String[0];
    public static String[] usedimages = new String[0];
    public static String[] previouslyusedimages = new String[0];
    public static String[] images = new String[0];
    public static String[] redunantimageglob = new String[0];
    public static JPanel panel = new JPanel(new FlowLayout());
    public static Label label = new Label();
    public static ImageIcon icon = new ImageIcon();
    public static String[] imageglob;

    public SlideShow() {
        loadImageGlob();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        add(panel);
        panel.setVisible(true);
        label.setVisible(true);

        label.setText("fuck you");


        Timer timer = new Timer();
        TimerTask task = new TimerHelper();
        timer.schedule(task, 1000, 5000);
        /*add caro*/

    }
    public static void loadImageGlob() {
        System.out.println("grabImages\n");
        imageglob = FileContentReader.main();
    }

    public static String[] genImageList() {
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

    public static void loadImages(String[] imagepaths) { /**/
        System.out.println("add images to caro"); /**/
        for (int i = 0; i < imagepaths.length; i++) { /**/
            System.out.println("for on files;"); /**/
            System.out.println(imagepaths[i]); /**/
            /*load images into caro*/
        }
    }
}


class TimerHelper extends TimerTask {
    public int counter = 1;
    public void run() {
        SlideShow.panel.add(SlideShow.label);

        if (counter == 0) {
            System.out.println("SWIPING");
            /*swipe on caro until end*/
            counter = 1;

        } else {
            System.out.println("else!!!");
            SlideShow.loadImageGlob();
            SlideShow.usedimages = new String[0];

            /*clear carousel*/
            String[] x = SlideShow.genImageList();
            SlideShow.loadImages(x);
            counter = 0;

        }
    }
}


class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}