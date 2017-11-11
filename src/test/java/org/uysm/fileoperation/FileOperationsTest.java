package org.uysm.fileoperation;

import org.junit.*;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class FileOperationsTest {

    String folderDir = "/Users/adnanrimedzo/IdeaProjects/pddx/src/test/java/resources/input/test.pddx";

    String hash = "1b7352f22302cf1b0d42422f21cc790c4f81ac8801a" +
            "938449cedd528dbe9e9b7d2160e670a6261bcd5164a5b21" +
            "64a89e98a34b54ccd59944ccc68fcc725f12ce374636791" +
            "9d55fa43101e0d2e1f2ff1c1c824499622e0643024f9d77bfebcbd2";

    @Test
    public void openFile() throws IOException {
        String result = FileOperations.openFile(folderDir);
        assertEquals(hash,result);
    }
}