package company.recent.amazon.onlineassesment;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TreasureIsland2
{

    public static void main(String[] args)
    {
        char[][] grid1 = new char[][] { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' },
                { 'O', 'O', 'O', 'O', 'X' }, { 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };

        char[][] grid2 = new char[][] {
                { 'S', 'O', 'O', 'S', 'S' },
                { 'D', 'O', 'D', 'O', 'O' },
                { 'O', 'O', 'O', 'O', 'X' },
                { 'X', 'D', 'D', 'O', 'O' },
                { 'X', 'D', 'D', 'D', 'O' } };

        System.out.println(treasureIsland(grid1));
        System.out.println(treasureIsland(grid2));

    }


    public static int treasureIsland(char[][] island)
    {
        if(island.length == 0)
            return -1;

        int[][] nei = {{0,1},{1,0},{-1,0},{0,-1}};

        int m = island.length;
        int n = island[0].length;

        int[][] dist = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();
        for(int i =0; i<m;i++){
            for(int j=0; j<n;j++){
                if(island[i][j] == 'X'){
                    dist[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){

            int[] cur = q.poll();
            if(island[cur[0]][cur[1]] == 'S')
                if(min> dist[cur[0]][cur[1]])
                    min = dist[cur[0]][cur[1]];

            for(int[] ne :nei){
                int r = cur[0]+ne[0];
                int c = cur[1]+ne[1];

                if(r>=0 && r<m && c>=0 && c<n )
                    if(island[r][c] =='O'||island[r][c] == 'S'){
                    if(dist[r][c] > dist[cur[0]][cur[1]]+1){
                        dist[r][c] = dist[cur[0]][cur[1]]+1;
                        q.offer(new int[]{r,c});
                    }
                }

            }

        }
return min;
    }


    }
