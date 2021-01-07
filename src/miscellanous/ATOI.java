package miscellanous;

import java.util.Arrays;

public class ATOI
{

    public static void main(String[] args)
    {
        System.out.println( -2147483648 -1);
    }

    static int myAtoi(String str) {


        // trim
        str = str.trim();

        if(str.length() == 0)
            return 0;
        char[] chars =  str.toCharArray();

        char c1 = chars[0];

        if(c1 == '+'  ||  c1 == '-')
        {
            if(chars.length>1){
                if(chars[1]>='0' && chars[1]<='9'){
                    return process(chars, true);
                }
                else
                    return 0;
            }
            else
                return 0;

        }
        else if(c1 >= '0' && c1<='9')
        {
            return process(chars, false);

        }
        else
            return 0;
    }

   static int process (char[] chars, boolean sign){
        int i =1;
        boolean isNegative = false;
        if(chars[0] == '-')
            isNegative = true;
        if(sign)
            i = i+1;

        while(i<chars.length){
            if(!(chars[i]<='9' && chars[i]>='0'))
                break;
            i++;
        }

        chars = Arrays.copyOf(chars,i);

        i = 0;
        if(sign)
            i++;

        int j =0;
        int sum = 0;
        while(i<chars.length){
            int num = chars[i] - '0';
            sum = num + sum*10;
            i++;
            j++;
        }

        return sum;

    }

}
