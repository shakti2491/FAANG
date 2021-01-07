package company.recent.amazon.onlineassesment;

import java.util.Arrays;
import java.util.HashSet;

public class MostCommonWord
{
    public static String mostCommonWord(String paragraph, String[] banned) {
        String words[] = paragraph.split(" ");
        HashSet<String> banSet = new HashSet<>(Arrays.asList(banned));

        for(String w : words){

            String stri = w.replaceAll("\\W", "");
            System.out.println();
        }
        return null;
    }

    public static void main(String[] args)
    {

        mostCommonWord("sdfg sdfsad sdfasdf, dsfas.",new String[]{"afda","afa"});
    }
}
