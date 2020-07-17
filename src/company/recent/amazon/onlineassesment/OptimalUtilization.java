package company.recent.amazon.onlineassesment;

import java.util.*;

public class OptimalUtilization
{
    public static void main(String[] args)
    {
        int [][] arr = {{1, 8}, {2, 15}, {3, 9}};
        int[][] arr2 = {{1, 8}, {2, 11}, {3, 12}};
        getPairs(Arrays.asList(arr), Arrays.asList(arr2),20);
    }

  static   List<int[]> getPairs (List<int[]> list1, List<int[]> list2, int target){
        // sort each of the array to bring down time complexity from O(n^2) to O (nlgn)


        Collections.sort(list1, Comparator.comparingInt(item -> item[1]));
        Collections.sort(list2, Comparator.comparingInt(item -> item[1]));

        List<int[]> result = new ArrayList<>();

        if(list1.size()==0 || list2.size()==0)
            return result;
        int max =Integer.MIN_VALUE;
        int m = list1.size();
        int n = list2.size();
        int i = 0;
        int j = n-1;

        while (i<m && j>=0){
            int sum = list1.get(i)[1]+list2.get(j)[1];
            if(sum>target){
                j--;
            }else{

                if(max <= sum){
                    if(max < sum)
                    {
                        max = sum;
                        result.clear();
                    }
                        result.add(new int[] {list1.get(i)[0], list2.get(j)[0]});
                         int index = j-1;
                         while (index>=0 && list2.get(j)[1] == list2.get(index)[1]){
                             result.add(new int[]{list1.get(i)[0], list2.get(index--)[0]});
                         }
                }
                i++;
            }

        }






return result;



    }


}
