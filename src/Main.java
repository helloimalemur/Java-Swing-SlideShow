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
        System.out.println("grabImages\n");
        ims = FileContentReader.main();
    }

    public static String[] genList() {
        System.out.println("genlist\n");
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
        tusedset.toArray(tused);
        igset.toArray(ig);
        pusedset.toArray(pused);
        return using;
    }

    public static void loadImages(String[] im) {
        /*add images to carousel*/
        System.out.println("add images to caro\n");
        for (int i = 0; i < im.length; i++) {
            System.out.println("for on files;");
            System.out.println(im[i]);
        }
    }
}


class TimerHelper extends TimerTask {
    public int counter = 0;
    public void run() {
        SlideShow.panel.add(SlideShow.label);
        SlideShow.using = SlideShow.genList();
        System.out.println("using length:");
        System.out.println(SlideShow.using.length);

        if (counter == 0) {
            System.out.println("if is true");
            counter = 1;

        } else {
            System.out.println("else!!!");
            String[] x = SlideShow.genList();
            /*clear carousel*/
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