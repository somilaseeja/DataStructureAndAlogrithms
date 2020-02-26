package DP;

/**
 * @author SOMIL ASEEJA
 * 2020-02-19 23:37
 * Ques: https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * Sol : https://www.youtube.com/watch?v=NJuKJ8sasGk (without using 1 in the coins).
 */
public class MinCoinChangeProblem {

    public static void main(String[] args) {
        int[] coins =   {1,5,6,9};
        int total   =   9;
        MinCoinChangeProblem mccp   =   new MinCoinChangeProblem();
        System.out.println(mccp.findMin(coins,total));
    }

    public int findMin(int[] coins, int total){
        int[] t =   new int[total+1];
        t[0]    =   0;

        for(int i = 1; i < t.length ; i++){
            t[i]    =   Integer.MAX_VALUE - 1;
        }

        for(int i = 0 ; i < coins.length ; i++){
            for(int j = 0 ; j < t.length ; j++){
                if(coins[i] <= j){
                    if(t[j-coins[i]] + 1 < t[j]) {
                        System.out.println("coin : " + coins[i] + " j : " + j + " j-coins[i] : " + (j - coins[i]) + " t[j-coins[i]] " + (t[j - coins[i]]));
                        t[j] = t[j - coins[i]] + 1;
                        printArray(t);
                    }
                }
            }
        }
        return t[total];

    }

    public void printArray(int[] t){
        for(int i = 0; i < t.length ; i++){
            System.out.print(t[i]);
            if(i < t.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
