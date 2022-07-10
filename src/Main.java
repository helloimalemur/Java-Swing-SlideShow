import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.nio.*;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;

class SlideShow extends JFrame {
    public static String[] used = new String[0];
    public static String[] using = new String[0];
    public static String[] tused = new String[0];
    public static String[] pused = new String[0];
    public static String[] images = new String[0];
    public static String[] ig = new String[0];
    public static JPanel panel = new JPanel(new FlowLayout());
    public static Label label = new Label();
    public static ImageIcon icon = new ImageIcon();
    public static String[] ims;

    public SlideShow() {
        grabImages();
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
        timer.schedule(task, 1000, 2000);


    }
    public static void grabImages() {
        System.out.print("grabImages\n");
        ims = FileContentReader.main();
    }

    public static String[] genList() {
        System.out.print("genlist\n");
        ig = ims;
        pused = using;
        Set<String> tusedset = new HashSet<>();
        Set<String> pusedset = new HashSet<>(Arrays.asList(pused));
        Set<String> igset = new HashSet<>(Arrays.asList(ig));
        Set<String> usingset = new HashSet<>(Arrays.asList(using));
        Set<String> usset = new HashSet<>(Arrays.asList(ims));

        tusedset.addAll(pusedset);
        usset.removeAll(tusedset);
        using = new String[usset.size()];
        usset.toArray(using);
        return using;
    }

    public static void loadImages(String[] im) {
        /*add images to carousel*/
        System.out.print("add images to caro\n");
        for (int i = 0; i < im.length; i++) {
            System.out.print(im[i]);
            System.out.print("\n");
        }
    }
}


class TimerHelper extends TimerTask {
    public int counter = 0;
    public void run() {
        SlideShow.panel.add(SlideShow.label);
        SlideShow.using = SlideShow.genList();
        System.out.println(SlideShow.using.length);

        if (SlideShow.using.length > 0) {
            System.out.print("if is true");
            for (int d = 0; d < SlideShow.using.length; d++) {
                System.out.println(SlideShow.using[d]);
                System.out.print("\n");
            }

        } else {
            SlideShow.ig = SlideShow.ims;
            /*SlideShow.grabImages();*/
            SlideShow.tused = SlideShow.using;
            String[] x = SlideShow.genList();
            /*clear carousel*/
            SlideShow.loadImages(x);

        }
    }
}


class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}