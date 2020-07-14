package miscellanous;

import java.util.HashMap;
import java.util.Map;

public class StateStore
{
    public static void main(String[] args)
    {
     prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1} , 66);
    }

    static int[] prisonAfterNDays(int[] cells, int N) {

        if(N==0)
            return cells;

        int[] newS = new int[8];
        for(int i =1; i<7;i++)
            if(cells[i-1]==cells[i+1])
                newS[i] = 1;


        cells = newS;
        if(N==1)
            return cells;
        N --;
        // after 64 iterations we will definetely have state of N=1
        //TLE

        // state graph

        // state store
        int[][] stateStore = new int[64][8];
        Map<Integer, Integer> map = new HashMap<>();
        int n = 0;
        int[] newState = new int[8];
        while(n<64){
            newState = new int[8];
            for(int i =1;i<=6;i++){
                if(cells[i-1]==cells[i+1])
                    newState[i] = 1;
            }

            cells=newState;

            int match = findMatchingState(newState, stateStore);
            if(match==64){
                stateStore[n] = newState;
                map.put(n-1,n);
            }else
                map.put(n-1,n);

            n++;
            N--;
            if(N==0)
                return newState;
        }
        int x = findMatchingState(newState,stateStore);
        while(N>0){
            x = map.get(x);
            N--;

        }


        return stateStore[x];
    }

   static int findMatchingState(int[] arr , int[][] matrix){

        for(int i=0;i<matrix.length;i++){
            int match = matrix[0].length;
            for(int j=0;j<matrix[0].length;j++){
                if(arr[j] == matrix[i][j]){
                    match--;
                }
            }
            if(match == 0)
                return i;
        }
        return 64;

    }

}
