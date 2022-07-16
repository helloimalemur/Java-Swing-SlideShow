import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {





//load and print list of files in dir
     FileContentReader fcr = new FileContentReader(null);
     ArrayList<String> array = fcr.getFilesArray();

     for (int i=0; i<array.size(); i++) {
         System.out.println(array.get(i));
     }
//


    }
}

