package designpattern.structural.decorator.datasource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator
{
    private int compLevel = 6;

    public int getCompLevel()
    {
        return compLevel;
    }

    public void setCompLevel(int compLevel)
    {
        this.compLevel = compLevel;
    }

    public CompressionDecorator(DataSource source)
    {
        super(source);
    }

    @Override public void writeData(String data)
    {
        super.writeData(data);
    }

    @Override public String readData()
    {
        return super.readData();
    }


    private String compress(String data){
        byte[] byteData = data.getBytes();
        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout,new Deflater(6));
            dos.write(byteData);
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());

        }catch (IOException ex){
            return null;
        }
    }


    private String deCompress(String data){
        byte[] byteData = Base64.getDecoder().decode(data);

        try{
            InputStream in = new ByteArrayInputStream(byteData);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b ;
            while ((b=iin.read())!=-1){
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return new String(bout.toByteArray());
        }catch (IOException ex){
            return null;
        }

    }

}
