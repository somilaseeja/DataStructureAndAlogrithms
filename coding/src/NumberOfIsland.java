/**
 * @author SOMIL ASEEJA
 * 2020-02-23 22:17
 */
public class NumberOfIsland {

    public static void main(String[] args) {
        int[][] grid    = {
                {1, 1, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println(sol1(grid));
    }

    public static int sol1(int[][] grid){
        if(grid ==  null || grid.length == 0){
            return 0;
        }

        int numOfIslands    =   0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == 1){
                    numOfIslands    +=  dfs(grid,i,j);
                }
            }
        }
        return numOfIslands;

    }

    private static int dfs(int[][] grid, int i, int j) {

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j]  =   0;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        //below are optional if wanted to go diagonal.
        /*dfs(grid,i-1,j-1);
        dfs(grid,i-1,j+1);
        dfs(grid,i+1,j-1);
        dfs(grid,i+1,j+1);*/
        return 1;

    }

}
