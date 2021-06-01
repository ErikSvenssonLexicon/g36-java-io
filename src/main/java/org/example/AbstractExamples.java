package org.example;

public abstract class AbstractExamples {

    public void closeAll(AutoCloseable...closeables){
        if(closeables == null) return;
        for(AutoCloseable closeable : closeables){
            if(closeable != null){
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
