package company.recent.amazon.onlineassesment;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis
{
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n,n,"",result);
        return result;
    }

     static void helper (int l1, int l2, String curr, List<String> result){

        if(l1==0 && l2 ==0){
            result.add(curr);
            return;
        }
        if(l2>=0 && l1>=0 && l2>=l1)
        {
            helper(l1 - 1, l2, curr + "(", result);
            helper(l1, l2 - 1, curr + ")", result);
        }

    }

    public static void main(String[] args)
    {
        generateParenthesis(3);
    }
}
