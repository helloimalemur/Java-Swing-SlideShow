import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        List<String> x = FileContentReader.main();


        System.out.println(x);
    }
/*
    public GetImages(List paths) {
        public File paths[] = new File();

    }
*/

    /*loads images */
     public void LoadImages() {

    }


}



class Main{
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
    }
}