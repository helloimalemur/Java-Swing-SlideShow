import java.util.TimerTask;


class TimerHelper extends TimerTask {
    public int count = 1;
    Slides slides;
    public TimerHelper(Slides s) {
        slides = s;
    }
    public void run() {
        if (count == 0) {
            System.out.println("SWIPING");
            /*swipe on caro until end*/
            count = 1;
        } else {
            System.out.println("else!!!");
            /*SlideShow.usedimages = new String[0];*/
            /*clear carousel*/
            //slides.loadImages(slides.genImageList());
            String[] x = slides.genImageList();
            slides.loadImages(x);
            count = 0;

        }
        }
}