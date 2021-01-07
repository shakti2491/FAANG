package company.recent.amazon.onlineassesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralOrder
{
    public static void main(String[] args)
    {


        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr1 = {{1,2}, {3}, {3}, {}};

        allPathsSourceTarget(arr1 );
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();

        if(graph.length == 0 )
            return result;
        int last = graph.length-1;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph,0,last,list, result);
        return result;

    }


  static   void dfs(int[][] graph, int curr,int last, List<Integer> res, List<List<Integer>> result){


        if(curr==last){
            List<Integer> list = new ArrayList<>();
            list.addAll(res);
            result.add(list);
            return;
        }


        int[] children = graph[curr];
        for(int child: children){
            res.add(child);
            dfs(graph, child, last, res, result);
            result.remove(result.size()-1);
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        int m = matrix.length;
        int n= matrix[0].length;
        int dir=0;
        int top = 0; int down =m-1;  int left = 0; int right = n-1;
        while(top<=down && left<=right){
            if(dir==0){
                for(int i =left;i<=right;i++){
                    result.add(matrix[top][i]);
                }
                top=top+1;
            }
            else if(dir==1){
                for(int i=top;i<=down;i++){
                    result.add(matrix[i][right]);
                }
                right= right-1;
            }
            else if(dir ==2)
            {
                for(int i=right;i>=left;i--)
                    result.add(matrix[down][i]);

                down = down-1;

            }
            else if(dir ==3){
                for(int i=down;i>=top;i--)
                    result.add(matrix[i][left]);
                left = left+1;
            }
            dir = (dir+1)%4;

        }
        return result;
    }
}
