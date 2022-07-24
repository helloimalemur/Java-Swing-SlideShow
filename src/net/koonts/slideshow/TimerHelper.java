package net.koonts.slideshow;

import net.koonts.slideshow.Slides;

import java.util.TimerTask;


class TimerHelper extends TimerTask {
    public int count = 0;
    Slides var; //create empty object
    public TimerHelper(Slides s) { //constructor takes object as argument and links to local
        var = s;
    }
    public void run() {
        if (count == 0) {
            try {
                //place holder
            } catch(Exception exception) {
                System.out.println(exception); //if something happens throw exception and clear images
                count = 1;
            }
        } else {
            //place holder
            count = 0;

        }
    }
}

//
//TimerTask task = new net.koonts.slideshow.TimerHelper(slides);
//timer.schedule(task, 0, slides.timerinterval);
//