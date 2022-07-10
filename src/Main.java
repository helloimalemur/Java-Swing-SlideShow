import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.nio.*;
import java.util.List;
import java.util.Timer;

class SlideShow extends JFrame {
    public static JPanel panel = new JPanel(new FlowLayout());
    public static Label label = new Label();

    public SlideShow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        List<String> used = new ArrayList<>();
        List<String> using = new ArrayList<>();
        List<String> tused = new ArrayList<>();
        List<String> pused = new ArrayList<>();
        Timer timer = new Timer();
        TimerTask task = new TimerHelper();
        timer.schedule(task, 1000, 1000);
        add(panel);
        panel.setVisible(true);
        label.setText("not null");
        label.setVisible(true);
    }
}

class Meth {
    /*loads images */
    public void LoadImages() {
        List<String> x = FileContentReader.main();
        System.out.println(x.toString().length());
    }
}

class TimerHelper extends TimerTask {
    public int counter = 0;
    public void run() {
        Meth x = new Meth();
        x.LoadImages();
        counter++;
        System.out.println(counter);
        SlideShow.panel.add(SlideShow.label);

        SlideShow.label.setSize(counter, counter);
    }
}


class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}