package company.recent.amazon.onlineassesment;

import java.util.*;
import java.util.stream.Collectors;

public class TopK
{
    public static List topKFreqWords(int numFeatures,int topFeatures,
            String[] possibleFeatures, String[] featureRequest)
    {
        HashSet set = new HashSet<>();

        for(String s:possibleFeatures)
        {
            set.add(s.toLowerCase());
        }


        HashMap<String,Integer> words= new HashMap<>();
        for(String s:featureRequest)
        {
            for(String str:s.split("\\W"))
                if(set.contains(str.toLowerCase())) {
                    words.put(str.toLowerCase(), words.getOrDefault(str.toLowerCase(), 0) + 1);

                }
        }

        List<String> list = new ArrayList<>(words.keySet());
        Collections.sort(list,(a,b)->(words.get(a).equals(words.get(b)))?a.compareTo(b):(words.get(b)-words.get(a)));
        if(topFeatures>numFeatures)
            return list;
        return list.subList(0,topFeatures);
    }

    public static void main(String[] args)
    {
       String[] featureRequests = {"I wish my Kindle had even more storage",
            "I wish the battery life on my Kindle lasted 2 years", "I read in the bath and would enjoy a waterproof Kindle",
            "I want to take my Kindle into the hover. Waterproof please waterproof!", "It would be neat if my Kindle would hover on my desk when not in use",
            "How cool would it be if my Kindle charged in the sun via solar power?"};
       String[] possibleFeatures = {"storage", "battery", "hover", "alexa", "waterproof", "solar"};
      List<String> topK =  topKFreqWords(6,2,possibleFeatures,featureRequests);
        System.out.println(topK);
    }
}
