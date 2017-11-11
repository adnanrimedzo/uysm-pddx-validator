package org.uysm.fileoperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    public final static String openFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

}
