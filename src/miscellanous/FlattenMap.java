package miscellanous;

import java.util.HashMap;
import java.util.Map;

public class FlattenMap
{

    public static void main(String[] args)
    {
        HashMap<String , Object> map = new HashMap();
        HashMap<String , Object> map2 = new HashMap();
        map2.put("a","b");
        map.put("key1","value1");
        map.put("key2", map2);

        flatten(map);
        System.out.println();


    }

    static HashMap<String, String> map = new HashMap<>();
   static HashMap<String, String> flatten(HashMap<String, Object> dict){
        flat("", dict);
        return map;
    }

    private static void flat(String oldKey, Object dict)
    {
        if(dict instanceof String){
            map.put(oldKey, (String)dict);
        }
        else{
            for(HashMap.Entry<String,Object> entry : ((HashMap<String, Object>)dict).entrySet())
            {
                String newKey = entry.getKey();
                Object newValue = entry.getValue();
                if (oldKey.equals(""))
                    flat(newKey, newValue);
                else
                {
                    if (newKey.equals(""))
                    {
                        flat(oldKey, newValue);
                    }
                    else
                        flat(oldKey + "." + newKey, newValue);
                }
            }
        }
    }
}
