import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileContentReader {

    private static final String FOLDER_PATH = "/home/foxx/Pictures/test/";

    public static String[] main() {
        Path folderPath = Paths.get(FOLDER_PATH);
        // retrieve a list of the files in the folder
        ArrayList<String> fileNames = new ArrayList<>();

        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(folderPath);
            for (Path fpath : directoryStream) {
                fileNames.add(fpath.toString());
            }
        } catch(IOException e) {
            System.out.print("something fucked up");
        }

        String[] fileName = new String[fileNames.size()];

        for (int i = 0; i < fileNames.size(); i++) {
            fileName[i] = fileNames.get(i);
        }


        return fileName;
    }

        /*// go through the list of files
        for (String file : fileNames); {
            try {
                // put the file's name and its content into the data structure
                List<String> lines = Files.readAllLines(folderPath.resolve(file));
                linesOfFiles.put(file, lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }