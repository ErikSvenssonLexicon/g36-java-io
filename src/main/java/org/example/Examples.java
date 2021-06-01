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

    public void bufferedCopy(File source, File destination){
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try{
            in = new BufferedInputStream(new FileInputStream(source));
            out = new BufferedOutputStream(new FileOutputStream(destination));

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0){
                out.write(buffer, 0, bytesRead);
                out.flush();
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            closeAll(in, out);
        }
    }



}
