package miscellanous;

import java.util.Stack;

public class DecodeString
{
    public String decodeString(String s) {

        int len = s.length();
        int start = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i)) && flag)
            {
                start = i;
                flag = false;
            }
            if(s.charAt(i)=='[')
                stack.push('[');
            if(s.charAt(i)==']')
                stack.pop();
            if(flag)
                sb.append(s.charAt(i));

            if(stack.isEmpty()&&s.charAt(i)==']'){
                sb.append(decode(s,start).str);
                flag =true;
            }

        }



        return  sb.toString();
    }


    private Result decode(String str, int index){

        if(str.charAt(index) == ']')
            return new Result("", index);

        int endIndex = index+1;
        while(str.charAt(endIndex)>='0' && str.charAt(endIndex)<='9')
            endIndex++;
        int num = Integer.valueOf(str.substring(index, endIndex));
        index = ++endIndex;
        while(Character.isAlphabetic(str.charAt(endIndex)))
            endIndex++;
        String prefix = str.substring(index,endIndex);
        Result mid = decode(str,endIndex);
        int end = mid.endIndex;
        StringBuilder suffix = new StringBuilder();
        while (end+1 < str.length()){
            if(str.charAt(end+1)!=']')
            suffix.append(str.charAt(end+1));
            end++;
        }
        String result = prefix+mid.str;
        return new Result(multiple(num,result),end);
    }

    class Result{
        String str;
        int endIndex;

        Result(String s , int i){
            str = s;
            endIndex = i;
        }
    }

    private  String multiple(int n, String str){

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append(str);
        }
        return sb.toString();
    }


    public static void main(String[] args)
    {
        DecodeString ds = new DecodeString();
        String s = "3[a]2[b4[F]c]";
        ds.decodeString(s);
    }
}
