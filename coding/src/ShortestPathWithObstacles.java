import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author SOMIL ASEEJA
 * 2020-02-14 14:14
 *
 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle).
 * In one step, you can move up, down, left or right from and to an empty cell.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0)
 * to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles.
 * If it is not possible to find such walk return -1.
 *
 *
 * Example 1:
 *
 * Input:
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6.
 * Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 *
 *
 * Example 2:
 *
 * Input:
 * grid =
 * [[0,1,1],
 *  [1,1,1],
 *  [1,0,0]],
 * k = 1
 * Output: -1
 * Explanation:
 * We need to eliminate at least two obstacles to find such a walk.
 *
 *
 * Constraints:
 *
 * grid.length == m
 * grid[0].length == n
 * 1 <= m, n <= 40
 * 1 <= k <= m*n
 * grid[i][j] == 0 or 1
 * grid[0][0] == grid[m-1][n-1] == 0
 */

/**
 * Time limit exceeding
 */
public class ShortestPathWithObstacles {

    int min =   Integer.MAX_VALUE;

    public static void main(String[] args) {
        ShortestPathWithObstacles sp    =   new ShortestPathWithObstacles();
        int[][] grid    = {
                {0, 0, 0},
                {1, 1, 1},
                {1, 1, 1},
                {0, 1, 1},
                {0, 0, 0}
        };
        System.out.println(sp.shortestPath(grid,1));
    }


    public int shortestPath(int[][] grid, int k) {
        int rows            =   grid.length;
        int cols            =   grid[0].length;
        System.out.println("Rows:"+rows+" cols : "+cols);
        int[][] visited     =   new int[rows][cols];
        recursivePath(grid, rows, cols, 0, 0,visited, 0,k);
        return min == Integer.MAX_VALUE ? -1 : min;

    }

    /**
     * Leet code fails as time gets exceeded.
     * @param grid
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @param currPath
     * @param k
     * @return
     */
    public int recursivePath(int[][] grid,int rows, int cols, int row,int col,int[][] visited, int currPath,int k){

        visited[row][col] = 1;
        System.out.println("===============================================");
        System.out.println("row :"+row+" col : "+col+" k : "+k+" currPath : "+currPath+" min : "+min);
        print(grid);
        System.out.println("\n");
        print(visited);

        if(row  ==  rows-1 && col == cols-1){
            if(currPath < min){
                min =   currPath;
            }
            System.out.println("End found : "+min);
            return currPath;
        }

        int val =   grid[row][col];

        if(val == 1) {
            System.out.print("Obstruction found..");
            if (k == 0) {
                System.out.print("Cannot cross more\n");
                return -1;
            } else {
                System.out.print("Going over it\n");
                k--;
            }
        }


        //1. go right, if col+1 is less than size of col && col+1 is not visited
        int right    =   0;
        if(col+1 < cols && visited[row][col+1] != 1){
            System.out.println("Going right");
            right    =   recursivePath(grid,rows,cols,row,col+1,visited,currPath+1,k);
            visited[row][col+1] = 0;
            //System.out.println(row+","+col+" Right : "+right);
        }

        //2. go left, if col-1 is greate than 0 && col-1 is not visited
        int left    =   0;
        if(col-1 >= 0 && visited[row][col-1] != 1){
            System.out.println("Going left");
            left    =   recursivePath(grid,rows,cols,row,col-1,visited,currPath+1,k);
            visited[row][col-1] = 0;
            //System.out.println(row+","+col+" Left : "+left);
        }
        //3. go up, if row-1 is greater than 0 && row-1 is not visited
        int up  =   0;
        if(row-1 >= 0 && visited[row-1][col] != 1){
            System.out.println("Going up");
            up    =   recursivePath(grid,rows,cols,row-1,col,visited,currPath+1,k);
            visited[row-1][col] =   0;
            //System.out.println(row+","+col+" up : "+up);
        }

        //4. go down, if row+1 is less than size of row && row+1 is not visited.
        int down  =   0;
        if(row+1 < rows && visited[row+1][col] != 1){
            System.out.println("Going down");
            down    =   recursivePath(grid,rows,cols,row+1,col,visited,currPath+1,k);
            visited[row+1][col] =   0;
            //System.out.println(row+","+col+" Down : "+down);
        }

        int horizontalMin   =   right > left ? left : right;
        int verticalMin     =   up > down ? down : up;

        int currMax =   horizontalMin > verticalMin ? verticalMin : horizontalMin;

        return currMax;

    }

    public void print(int[][] arr){
        int r   =   arr.length;
        int c   =   arr[0].length;

        for(int i = 0 ; i < r ; i++){
            for(int j =0 ; j < c ; j++){
                System.out.print(arr[i][j]);
                if(j<c-1){
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }
}
