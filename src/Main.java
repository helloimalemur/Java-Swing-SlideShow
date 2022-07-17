import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

class SlideShow extends JFrame {
    public static GraphicsEnvironment graphics;
    public static GraphicsDevice device;

    public Slides slides = new Slides(); //initialize Slides class
    public SlideShow() {
        //initialize graphics environment and attach to graphics device
        graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphics.getDefaultScreenDevice();
        //on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set JFrame 'Slideshow' size and visibility
        setSize(1000,1000);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        //add panel created in Slides class and set visibility
        add(slides.panel);
        slides.panel.setSize(1000,1000);
        slides.panel.setVisible(true);
        // set 'this' JFrame 'Slideshow' to be fullscreen
        device.setFullScreenWindow(SlideShow.this);
        // start Timer schedule
        Timer timer = new Timer();
        TimerTask task = new TimerHelper(slides);
        timer.schedule(task, 0, 3000);
    }

    public static GraphicsDevice getDevice() {
        return device;
    }

}
class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}