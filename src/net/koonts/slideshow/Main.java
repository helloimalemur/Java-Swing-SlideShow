package net.koonts.slideshow;

class Main {
    public static void main(String args[]){

        String arg1 = args[0];
        System.out.println(arg1);

        if (arg1 == null) {
            System.out.println("no args taken");
            arg1 = "/home/foxx/Pictures/test/";
            System.out.println("set path to: " + arg1);
        }

        SlideShow slideshow = new SlideShow(arg1);
    }
}