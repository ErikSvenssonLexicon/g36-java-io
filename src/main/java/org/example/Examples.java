package org.example;

import java.io.*;

public class Examples extends AbstractExamples{

    public void copy(File source, File destination){
        InputStream in = null;
        OutputStream out = null;
        try{
            in = new FileInputStream(source);
            out = new FileOutputStream(destination);

            int b;
            while((b = in.read()) != -1){
                out.write(b);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeAll(in, out);
        }
    }



}
