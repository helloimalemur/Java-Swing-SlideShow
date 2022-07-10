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
        timer.schedule(task, 0, 2000);
        grabImages();

    }
    public static void grabImages() {
        System.out.print("grabImages");
        ims = FileContentReader.main();
    }

    public static String[] genList() {
        System.out.print("genlist");
        ig = ims;
        pused = using;
        Set<String> tusedset = new HashSet<>(Arrays.asList(tused));  /*list(set(self.pused) | set(self.tused))*/
        Set<String> pusedset = new HashSet<>(Arrays.asList(pused));
        Set<String> igset = new HashSet<>(Arrays.asList(ig));
        Set<String> usingset = new HashSet<>(Arrays.asList(using));
        Set<String> usset = new HashSet<>(Arrays.asList(ims));

        tusedset.addAll(pusedset);
        usset.removeAll(tusedset);
        String[] using = new String[usset.size()];
        usset.toArray(using);
        return using;




    }

    public static void loadImages(String[] im) {
        /*add images to carousel*/
        System.out.print("add images to caro");
        for (int i = 0; i < im.length; i++) {
            System.out.print(i);
        }
    }
}


class TimerHelper extends TimerTask {
    public int counter = 0;
    public void run() {
        SlideShow.panel.add(SlideShow.label);

        if (counter == 0) {
            /*next slide*/
            System.out.print("if is true");
            for (int d = 0; d < SlideShow.ims.length; d++) {
                System.out.println("---------------");
                System.out.println(d);
                System.out.print(SlideShow.ims[d]);

            }
            counter++;
        } else {
            SlideShow.ig = SlideShow.ims;
            SlideShow.grabImages();
            SlideShow.tused = null;
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