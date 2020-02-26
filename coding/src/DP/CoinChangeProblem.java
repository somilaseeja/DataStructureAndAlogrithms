package DP;

/**
 * @author SOMIL ASEEJA
 * 2020-02-19 22:51
 *
 * Ques : https://www.geeksforgeeks.org/coin-change-dp-7/
 * Sol : https://www.youtube.com/watch?v=Y0ZqKpToTic
 *
 *
 */
public class CoinChangeProblem {

    public static void main(String[] args) {

        int[] coins =   {1,2,3,4,5};
        int total   =   5;
        CoinChangeProblem   ccp =   new CoinChangeProblem();
        System.out.println(ccp.numberOfWays(coins,total));

    }

    public int numberOfWays(int[] coins, int total){

        int[][] matrix  =   new int[coins.length][total+1];

        for(int i = 0; i < total+1 ; i++){
            matrix[0][i]    =   1;
        }

        for(int i = 1 ; i < coins.length ; i++){
            for(int j = 0 ; j < total + 1 ; j++){
                if(coins[i] > j){
                    matrix[i][j] = matrix[i-1][j];
                }else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-coins[i]];
                }
            }
        }
        return matrix[coins.length-1][total];
    }

}
