package net.koonts.slideshow;

class Main {
    public static void main(String args[]){
        SlideShow slideshow = new SlideShow();
        String[] arguments = new String[args.length];

        for (int i=0; i<args.length; i++) {
            arguments[i] = args[i];
        }
        slideshow.path = arguments[0];
    }
}