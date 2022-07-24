package net.koonts.slideshow;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*Takes path input and returns String Array <String[]> of paths*/
public class FileContentReader {
    private ArrayList<String> fileNames = new ArrayList<>();
    private String FOLDER_PATH;

    public FileContentReader(String path) {
        if (path == null) {
            System.out.print("path is not valid.. Quitting..");
            System.exit(0);
        } else {
            FOLDER_PATH = path;
        }
    }

    public String[] getFiles() {
        Path folderPath = Paths.get(FOLDER_PATH);
        // retrieve a list of the files in the folder
        try {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(folderPath);
            for (Path fpath : directoryStream) {
                fileNames.add(fpath.toString());
            }
        } catch(IOException e) {
            System.out.print("unable to load images.. Quitting..");
            System.exit(0);
        }
        String[] fileName = new String[fileNames.size()];
        for (int i = 0; i < fileNames.size(); i++) {
            fileName[i] = fileNames.get(i);
        }
        return fileName;
    }

    public ArrayList<String> getFilesArray() {
        getFiles();
        return fileNames;
    }
}
