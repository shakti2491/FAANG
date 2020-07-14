package miscellanous;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class MisType
{
    public static void main(String[] args)
    {
        String[] x = {"hello", "hi", "helo"};
        expressiveWords("heeellooo",x);
    }

    static int expressiveWords(String S, String[] words) {

        String enhancedCached [] = process(words);

        // preprocessing of input
        String[] x1 = new String[1];
        x1[0] = S;
        String x2[] = process(x1);

        // here we will have actual strings
        List<Pair<Integer, String>> matched  = match(x2[0],enhancedCached, words);

        return stretchy(matched,S).size();

    }



  static   String [] process(String[] words){

        String[] enhanced = new String[words.length];

        for(int i =0; i<words.length;i++){
            StringBuilder sb = new StringBuilder();
            char[] chars = words[i].toCharArray();
            int k = 0;
            sb.append(chars[k]);
            for(int j =1;j<chars.length;j++){
                if(chars[k]!=chars[j]){
                    sb.append(chars[j]);
                    k=j;
                }
            }

            enhanced[i] = sb.toString();
        }

        return enhanced;
    }

  static   List<Pair<Integer,String>> match (String S, String [] enhancedCached, String[] words){
        List<Pair<Integer,String>> matched = new ArrayList<>();

        for(int i =0;i<enhancedCached.length; i++){
            if(enhancedCached[i].equalsIgnoreCase(S))
                matched.add(new Pair<>(i, words[i]));
        }

        return matched;
    }

   static List<Pair<Integer,String>> stretchy(List<Pair<Integer, String>> list, String S){
        List<Pair<Integer,String>> stretchy = new ArrayList<>();
       char[] charS = S.toCharArray();
        for(Pair<Integer, String> pair : list){
            char[] charT =pair.getValue().toCharArray();
            int s =0;
            int t =0;
            boolean status = true;
            while (s<charS.length && t <charT.length){
                int counts =0;
                int countt =0;
                char currC = charS[s];
                while ( s<charS.length && charS[s]== currC){
                    counts++;
                    s++;
                }

                while (t <charT.length && charT[t]==currC){
                    countt++;
                    t++;
                }
                if(counts-countt >0 & counts<3)
                {
                    status = false;
                    break;
                }

            }
            if(status)
                stretchy.add(pair);

        }

        return stretchy;
    }

}
