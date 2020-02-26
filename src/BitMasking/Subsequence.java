package BitMasking;

/**
 * @author SOMIL ASEEJA
 * 2020-02-23 17:03
 */
public class Subsequence {

    public static void main(String[] args) {
        char[] arr  =   {'a','b','c'};
        int range   =   (1<<arr.length)-1; // i.e. 2^n-1;
        System.out.println(range);
        for(int i = 0 ; i <= range ; i++){
            generateSeq(arr,i);
        }
    }

    /**
     *
     * @param arr
     * @param n
     * for every n we initiate i = 0
     * if n = 101
     * 101&1 = 1
     * we print a, i = 1
     * next 10&1 = 0
     * we dont pick b, i = 2
     * 1&1 = 1
     * we print c
     * so the 5th sequence is ac
     *
     * this will be done for every n : 0 to range-1
     */
    public static void generateSeq(char[] arr, int n){
        int i = 0;
        String curr =   "";
        while(n>0){
            //System.out.println("i : "+i+" n : "+n+" n&1 "+(n&1) +"\n");
            if((int)(n&1) == 1){
                curr    += arr[i];
            }
            i++;
            n = n>>1;
        }
        System.out.println(curr);
    }
}
