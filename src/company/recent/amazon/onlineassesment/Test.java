package company.recent.amazon.onlineassesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {

        List<Integer> list = new ArrayList<>(Arrays.asList(12,3,4,6,3));

        int x = 3, y =3;
        boolean checkX = false;
        boolean checkY= false;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==x)
                checkX = true;
            if(list.get(i)==y)
                checkY =true;
            if(checkX&&checkY)
                break;
        }

        System.out.println(!(checkX&&checkY));

    }




}
