import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.Timer;

class SlideShow extends JFrame {
    public static GraphicsEnvironment graphics;
    public static GraphicsDevice device;
    public Timer timer;

    public static Slides slides = new Slides(); //initialize Slides class
    public SlideShow() {
        //initialize graphics environment and attach to graphics device
        graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphics.getDefaultScreenDevice();

        //on close
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //set JFrame 'Slideshow' size and visibility
        setSize(1000,1000);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        //add panel created in Slides class and set visibility
        add(slides.panel);
        //slides.panel.setSize(1000,1000);
        // set 'this' JFrame 'Slideshow' to fullscreen
        //setExtendedState(this.MAXIMIZED_BOTH);
        //setResizable(false);
        //pack();
        //setBackground(Color.BLACK);
        Keys keys = new Keys();
        addKeyListener(keys);
        // set 'this' JFrame 'Slideshow' to be fullscreen
        device.setFullScreenWindow(SlideShow.this);
        // start Timer schedule
        start();

        //Button button = new Button();
        //button.addActionListener(keys);

    }

    public void pause() {
        timer.cancel();
    }

    public void start() {
        timer = new Timer();
        TimerTask task = new TimerHelper(slides);
        timer.schedule(task, 0, 3000);
    }

    public class Keys implements KeyListener, ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println(e.toString());
            if (e.getKeyChar() == 'q') {
                System.exit(0);
            }

            if (e.getKeyChar() == 'p') {
                pause();
            }

            if (e.getKeyChar() == 'r') {
                start();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
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