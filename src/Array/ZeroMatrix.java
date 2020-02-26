package Array;

/**
 * @author SOMIL ASEEJA
 * 2020-02-12 20:19
 *
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 *  --           --       --           --
 * | 1, 2, 0, 1, 6 |     | 0, 0, 0, 0, 0 |
 * | 5, 3, 2, 1, 0 |     | 0, 0, 0, 0, 0 |
 * | 4, 8, 9, 8, 6 | ==> | 4, 8, 0, 8, 0 |
 * | 7, 3, 0, 1, 5 |     | 0, 0, 0, 0, 0 |
 *  --           --       --           --
 */
public class ZeroMatrix {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 0, 1, 6},
                {5, 3, 2, 1, 0},
                {4, 8, 9, 8, 6},
                {7, 3, 0, 1, 5}
        };

        int rows = arr.length;
        int cols = arr[arr.length - 1].length;

        printMatrix(arr,rows,cols);
        System.out.println("\nAfter conversion\n");
        printMatrix(sol1(arr,rows,cols),rows,cols);
    }

    private static int[][] sol1(int[][] mat,int r, int c){

        int[] rowWith0  =   new int[r];
        int[] colWith0  =   new int[c];

        for(int i = 0; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(mat[i][j] == 0){
                    rowWith0[i] = -1;
                    colWith0[j] = -1;
                    break;//no need to go further as we encountered 0 in a row.
                }
            }
        }

        for(int i = 0 ; i < r ; i++) {
            for (int j = 0; j < c; j++) {

                if (rowWith0[i] == -1 || colWith0[j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }

        return mat;
    }

    private static void printMatrix(int[][] mat,int r, int c){
        for(int i = 0; i < r ; i++){
            for(int j = 0; j < c ; j++){
                System.out.print(mat[i][j]);
                if(j<c-1){
                    System.out.print(", ");
                }
            }
            System.out.print("\n");
        }
    }

}
