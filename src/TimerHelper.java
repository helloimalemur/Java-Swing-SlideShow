import java.util.TimerTask;


class TimerHelper extends TimerTask {
    public int count = 0;
    Slides slides;
    public TimerHelper(Slides s) {
        slides = s;
    }
    public void run() {
        if (count == 0) {
            try {
                slides.runner();
            } catch(Exception exception) {
                System.out.println(exception);
                count = 1;
            }
        } else {
            slides.clearImages();
            count = 0;

        }
    }
}