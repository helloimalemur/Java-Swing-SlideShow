package SlideShow;

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
    public java.util.Timer timer = new Timer();

    public static Slides slides; //initialize net.koonts.slideshow.Slides class



    public SlideShow(String paths) {
        slides = new Slides(paths);
        //initialize graphics environment and attach to graphics device
        graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphics.getDefaultScreenDevice();
        setBackground(Color.black);
        this.getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        add(slides.panel);
        Keys keys = new Keys();
        addKeyListener(keys);
        // set 'this' JFrame 'Slideshow' to be fullscreen
        device.setFullScreenWindow(SlideShow.this);
        //slides.panel.setSize(this.getWidth(), this.getHeight());
        slides.slideinterval = 3000;
        start();
    }


    public void start() {
        while (!(slides == null)) {
            slides.pause = false;
            slides.waspaused = false;
            slides.next = false;
            slides.panel.removeAll();
            slides.loadImageGlob(); //gets files glob and sets 'listofimages'
            slides.cycleImages(slides.listofimages);
        }
    }

    public void pause() {
        slides.pause = true;
    }

    public void resume() {
        slides.pause = false;
        slides.waspaused = false;
        slides.next = false;
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
                slides.overlay("Delay: ", slides.slideinterval);
            }

            if (e.getKeyChar() == 'z') { // z key decreased interval between slides
                if (slides.slideinterval >= 3000) {
                    slides.slideinterval = slides.slideinterval - 2000;
                    System.out.println("interval: " + slides.slideinterval);
                    slides.overlay("Delay: ", slides.slideinterval);
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
                System.out.println("Next..");
                slides.next = true;
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