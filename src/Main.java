import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

class SlideShow extends JFrame {
    public static GraphicsEnvironment graphics;
    public static GraphicsDevice device;
    public Timer timer = new Timer();


    public static Slides slides = new Slides(); //initialize Slides class
    public SlideShow() {
        //initialize graphics environment and attach to graphics device
        graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphics.getDefaultScreenDevice();


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        add(slides.panel);
        Keys keys = new Keys();
        addKeyListener(keys);
        // set 'this' JFrame 'Slideshow' to be fullscreen
        device.setFullScreenWindow(SlideShow.this);
        slides.slideinterval = 3000;
        start();
    }

    public void pause() {
        slides.pause = true;
    }

    public void resume() {
        slides.pause = false;
    }

    public void start() {
        slides.pause = false;
        slides.panel.removeAll();
        slides.cycleImages(slides.loadImageGlob());
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

            if (e.getKeyChar() == 'a') { // a key increases interval between slides
                slides.slideinterval = slides.slideinterval + 3000;
                System.out.println("interval: " + slides.slideinterval);
            }

            if (e.getKeyChar() == 'z') { // z key decreased interval between slides
                if(slides.slideinterval >= 3000) {
                    slides.slideinterval = slides.slideinterval - 2000;
                    System.out.println("interval: " + slides.slideinterval);
                }
            }

            if (e.getKeyChar() == 'q') { //quit the app
                System.out.println("Quitting..");
                System.exit(0);
            }

            if (e.getKeyChar() == 'p') { //pause when pressing "p" key
                System.out.println("Pausing..");
                pause();
            }

            if (e.getKeyChar() == 'r') { // resume
                System.out.println("Resuming..");
                resume();
            }

            if (e.getKeyChar() == 'n') { //next when pressing "n" key
                System.out.println("This does nothing..");
            }

            if (e.getKeyChar() == 'b') { //back when pressing "b" key
                System.out.println("Back one..");
                slides.back = true;
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