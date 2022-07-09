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

    public static List<String> main() {
        Path folderPath = Paths.get(FOLDER_PATH);

        // prepare a data structure for a file's name and content
        Map<String, List<String>> linesOfFiles = new TreeMap<String, List<String>>();

        // retrieve a list of the files in the folder
        List<String> fileNames = new ArrayList<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(folderPath)) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {
            System.err.println("Error reading files");
            ex.printStackTrace();
        }
        return fileNames;
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