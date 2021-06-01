package org.example;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

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

    public void writeToTextFile(File destination, String source){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(destination);
            if(!destination.exists()){
                destination.createNewFile();
            }
            fileWriter.write(source);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeAll(fileWriter);
        }
    }

    public String readFromTextFile(File source){
        StringBuilder stringBuilder = new StringBuilder();
        FileReader reader = null;
        try{
            reader = new FileReader(source);

            int i;
            while((i = reader.read()) != -1){
                char letter = (char) i;
                stringBuilder.append(letter);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeAll(reader);
        }
        return stringBuilder.toString();
    }

    List<String> writeStringsToFile(List<String> source, File destination){
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter(new FileWriter(destination));
            for(int i = 0; i<source.size(); i++){
                writer.write(source.get(i));
                if(i != source.size() -1){
                    writer.newLine();
                }
            }
            writer.flush();

        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            closeAll(writer);
        }
        return source;
    }

    public List<String> readStringsFromFile(File source){
        BufferedReader reader = null;
        List<String> result = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(source));

            String line;
            while ((line = reader.readLine()) != null){
                result.add(line);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            closeAll(reader);
        }
        return result;
    }

    public void foo(){
        Path path = Paths.get("destination/names.txt");
        Path dest = Paths.get("source/names.txt");

        try {
            Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean delete(Path path){
        return path.toFile().delete();
    }



}
