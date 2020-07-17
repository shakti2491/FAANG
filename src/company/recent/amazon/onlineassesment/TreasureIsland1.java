package company.recent.amazon.onlineassesment;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland1
{
    public static int treasureIsland(char[][] island) {
       if(island.length == 0)
           return -1;
       int m = island.length;
       int n = island[0].length;
       boolean[][] visited = new boolean[m][n];
       Queue<int[]> queue = new ArrayDeque<>();

       int[][] nei = {{0,1},{1,0},{-1,0},{0,-1}};

       visited[0][0] = true;
       queue.offer(new int[]{0,0});
       int steps = 0;

       while (!queue.isEmpty()){
           int len = queue.size();

           for(int j=0;j<len;j++){
               int[] cur = queue.poll();
               if(island[cur[0]][cur[1]]=='X')
                   return steps;
               for(int[] ne : nei){
                   int r = cur[0]+ne[0];
                   int c = cur[1]+ne[1];
                   if(r>=0&&r<m &&c>=0 &&c<n &&island[r][c]!='D'&& !visited[r][c]){
                       visited[r][c] = true;
                       queue.offer(new int[] {r,c});
                   }
               }
           }

           steps++;

       }

       return 0;

    }

    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = TreasureIsland1.treasureIsland(island);
        System.out.println(String.format("%s (expect 5)", result));
    }

}
