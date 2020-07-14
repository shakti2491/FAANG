package graph;

public class ClosedIslands
{
    public static void main(String[] args)
    {
        closedIsland(new int[][]{{1}});
    }
    static int closedIsland(int[][] grid) {
        // do dfs from the boundary
        // mark them as 2
        // after completing dfs from boundary
        // do a dfs on all zeros and
        //find number of strongly connected components connected components


        // dfs uppermost and lowermost row
        int x =0;
        while(x<grid.length){
            for(int j=0; j<grid[0].length;j++){
                if(grid[x][j]==0){
                    grid[x][j] = 2;
                    dfs(grid,x,j);

                }

            }
            x+=grid.length-1;
        }

        // dfs rightmost and leftmost column
        x=0;
        while(x<grid[0].length){
            for(int i =0;i<grid.length;i++){
                if(grid[i][x]==0){
                    grid[i][x]=2;
                    dfs(grid,i,x);
                }


            }
            x+=grid[0].length-1;
        }

        int count =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    grid[i][j] = 2;
                    dfs(grid,i,j);
                    count++;
                }

            }
        }

        return count;
    }

  static   int[][] neighbours = {{1,0},{0,1},{-1,0},{0,-1}};

    static void dfs (int[][] grid, int i, int j){
        for(int[] neighbour : neighbours){
            int r = i+neighbour[0];
            int c = j+neighbour[1];
            if(!(r<0 || r> grid.length-1 || c<0 || c>grid[0].length-1)){
                if(grid[r][c]==0){
                    grid[r][c] = 2;
                    dfs(grid, r,c);
                }
            }



        }


    }
}
