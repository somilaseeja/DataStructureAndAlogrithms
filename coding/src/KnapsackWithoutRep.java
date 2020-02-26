/**
 * @author SOMIL ASEEJA
 * 2020-02-10 15:13
 *
 * This idea is to solve the knapsack problem
 * with DP.
 * There are N items with weight W, and value v.
 * We need to maximize the value keeping W fixed .
 * For ex: W = {1,2,3,4}
 *         v = {10,20,40,50}
 *
 *  So the total weight i can use is 3. Then the maximum value can be 40
 *  by picking item with weight 3 and v = 40 instead of items with weight and 1,2
 *  as the value will be generated 30 in that case.
 *
 */
public class KnapsackWithoutRep {

    public static void main(String[] args) {

        int[] weight  =   {1,2,3,4};
        int[] values  =   {10,20,40,50};

        maxProfit(weight,values);


    }

    public static int maxProfit(int[] weight, int[] values){

        return 0;
    }

}
