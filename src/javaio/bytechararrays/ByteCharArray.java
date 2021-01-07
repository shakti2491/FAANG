package javaio.bytechararrays;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteCharArray
{
    void process() throws IOException
    {

        byte[] bytes = new byte[1028];

        try(InputStream inputStream = new ByteArrayInputStream(bytes))
        {

            int data = inputStream.read();
            while (data != -1)
            {
                data = inputStream.read();
            }
        }
    }
}
