package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SatisfiabilityEquation
{
    public static void main(String[] args)
    {
        String[] str = new String[] {"a==b","b!=a"};

        Map<String,Integer> map = new HashMap<>();
        map.put("abc",0);

        map.put("kbc",0);
        map.put("ksc",1);
        map.put("kcvc",1);
        map.put("kbaasdc",4);


        Map<String,Integer> parents = new HashMap<>();

        for(Map.Entry<String, Integer> entry: parents.entrySet()){

        }
        //equationsPossible(str);
    }

    static boolean equationsPossible(String[] equations) {
        Map<Character, Character> parent = new HashMap<>();

        for(String str : equations){
            char[] chars = str.toCharArray();

            if(chars[1]==chars[2]){

                char p1 = find(parent, chars[0]);
                char p2 = find(parent, chars[3]);

                if(p1!=p2)
                    parent.put(p1,p2);

            }

        }

        for(String str: equations){

            char[] chars = str.toCharArray();


            if(chars[1]!=chars[2]){
                char p1 = find(parent, chars[0]);
                char p2 = find(parent, chars[3]);

                if(p1==p2)
                    return false;
            }


        }

        return true;



    }


   static Character find(Map<Character, Character> parent, Character c){

        Character p = parent.get(c);
        if(p==null)
            return c;

        else
            return find(parent, p);


    }




}
