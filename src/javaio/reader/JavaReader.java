package javaio.reader;

import java.io.*;

public class JavaReader
{

    void read() throws IOException
    {
        byte[] bytes = new byte[1028];
        Reader reader = new FileReader("data.txt");
        InputStream inputStream = new ByteArrayInputStream(bytes);
        Reader reader2 = new InputStreamReader(inputStream);
        int data = reader.read();
        while (data!=-1){
            data = reader.read();
        }

    }
}
