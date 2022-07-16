import java.util.TimerTask;


class TimerHelper extends TimerTask {
    public int count = 1;
    Slides slides;
    public TimerHelper(Slides s) {
        slides = s;
    }
    public void run() {
        if (count == 0) {
            System.out.println("Timer if count 0");
            slides.runner();
            count = 1;
        } else {
            System.out.println("Timer if count 1");
            count = 0;

        }
    }
}