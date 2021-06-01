package org.example;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Examples examples = new Examples();
        File source = new File("source/java-logo-1.png");
        File destination = new File("destination/java-logo-1-copy.png");
        examples.copy(source, destination);
    }
}
