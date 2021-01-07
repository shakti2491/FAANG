package javaio.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample
{
    public static void main(String[] args) throws IOException
    {
        final PipedInputStream pipedInputStream = new PipedInputStream();
        final PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);


        Thread t1 = new Thread(() ->{
            try
            {
                pipedOutputStream.write("Hello world, pipe!".getBytes());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });


        Thread t2 = new Thread(()->{
            try
            {
                int data = pipedInputStream.read();
                while (data!=-1){
                    System.out.println(data);
                    System.out.println((char) data);
                    data = pipedInputStream.read();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
