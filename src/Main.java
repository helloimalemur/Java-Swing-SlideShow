import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

class SlideShow extends JFrame {
    public Slides slides = new Slides();
    public static JPanel panel = new JPanel(new FlowLayout());
    public SlideShow() {
        slides.loadImageGlob();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        add(panel);
        panel.setSize(1000,1000);
        panel.setVisible(true);
        Timer timer = new Timer();
        TimerTask task = new TimerHelper(slides);
        timer.schedule(task, 1000, 5000);
        /*add caro*/

    }
}





class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}