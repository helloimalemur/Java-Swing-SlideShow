import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.nio.*;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;

class SlideShow extends JFrame {
    public static List<String> used = new ArrayList<>();
    public static List<String> using = new ArrayList<>();
    public static List<String> tused = new ArrayList<>();
    public static List<String> pused = new ArrayList<>();
    public static List<String> images = new ArrayList<>();
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
    public void grabImages() {
        System.out.print("grabImages");
        ims = FileContentReader.main();
    }
}


class TimerHelper extends TimerTask {
    public int counter = 0;
    public void run() {
        SlideShow.panel.add(SlideShow.label);
        System.out.print(SlideShow.ims[0]);
        if (counter == 0) {
            /*next slide*/
            System.out.print("if is true");
            for (int d = 0; d < SlideShow.ims.length; d++) {
                System.out.println("---------------");
                System.out.println(d);
                System.out.print(SlideShow.ims[d]);

            }
            counter++;
        }
    }
}


class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}