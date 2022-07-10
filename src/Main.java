import javax.swing.*;
import java.awt.FlowLayout;
import java.util.*;
import java.nio.*;
import java.util.Timer;

class SlideShow extends JFrame {
    public SlideShow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
        setLayout(new FlowLayout());
        List<String> used = new ArrayList<>();
        List<String> using = new ArrayList<>();
        List<String> tused = new ArrayList<>();
        List<String> pused = new ArrayList<>();
        Timer timer = new Timer();
        TimerTask task = new TimerHelper();
        timer.schedule(task, 1000, 1000);
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
    public void run() {
        Meth x = new Meth();
        x.LoadImages();
    }
}


class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}