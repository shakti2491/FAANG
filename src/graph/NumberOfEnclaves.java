package graph;

import java.util.Stack;

public class NumberOfEnclaves
{

    public static void main(String[] args)
    {
        int[][] arr1 = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        numEnclaves(arr1);
    }

// dfs using a stack

    static int numEnclaves(int[][] A) {
        // do a dfs and count the number of elements of the dfs
        // if while traversal  we reach the boundary of the matrix return 0 during that dfs

        // return total count of the nodes of the safe dfs

        // four movements possible
        int[][] movement = {{0,1},{1,0},{-1,0},{0,-1}};

        boolean visited[][] = new boolean[A.length][A[0].length];
        int globalCount = 0;
        for(int i =0;i<A.length; i++){

            for(int j =0;j<A[i].length;j++){

                if(A[i][j] == 1 && !visited[i][j]){
                    Stack<int[]> stack = new Stack<>();
                    int count = 0;
                    int vertex []= {i,j};
                    stack.push(vertex);
                    visited[i][j] = true;

                    while(!stack.isEmpty()){

                        int[] node= stack.pop();
                        for(int k =0 ;k<4;k++){
                            // check the four neighbours

                            int r = node[0] + movement[k][0];
                            int  c = node[1] + movement[k][1];

                            if(r<0|| r>=A.length || c<0 || c>=A[0].length){
                                count = 0;
                                break;
                            }else
                            {
                                if(A[r][c] ==1 && !visited[r][c] ){
                                    int child[] =  {r,c};
                                    stack.push(child);
                                    visited[r][c] = true;
                                    count++;
                                }
                            }

                        }

                    }

                    globalCount +=count;
                }

            }
        }
        return globalCount;

    }
}
