package designpattern.structural.decorator.datasource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDataSource implements DataSource
{
    private String fileName;

    public FileDataSource(String name)
    {
        this.fileName = name;
    }

    @Override public void writeData(String data)
    {
        File file = new File(fileName);
        try(OutputStream fos = new FileOutputStream(file)){
            fos.write(data.getBytes(),0,data.length());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override public String readData()
    {
     char[] buffer = null;
     File file = new File(fileName);
        return null;
    }
}
