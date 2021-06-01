package org.example;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Examples examples = new Examples();
        List<String> stringList = new ArrayList<>();
        stringList.add("Johny");
        stringList.add("Olof");
        stringList.add("Peter");
        stringList.add("Adam");
        stringList.add("Oskar");
        stringList.add("Thomas");
        stringList.add("David");
        stringList.add("Nils");
        stringList.add("Majid");

        File file = new File("destination/names.txt");

        examples.delete(Paths.get("source/names.txt"));
    }
}
