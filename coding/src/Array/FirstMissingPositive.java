package Array;

/**
 * @author SOMIL ASEEJA
 * 2020-02-21 12:29
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        //int arr[]   =   {-10,2,-20,1,4,5};
        int arr[]   =   {1,1};
        System.out.println(posNum(arr));

    }


    public static int posNum(int[] arr){
        print(arr);
        int lastNegIndex   =   shiftNegative(arr);
        System.out.println("Last Index : "+lastNegIndex);
        if(lastNegIndex == arr.length-1){
            if(arr[lastNegIndex] > 0) {
                return arr[lastNegIndex]+1;
            }else {
                return 1;
            }
        }

        int startIndex  =   lastNegIndex + 1;
        print(arr);
        for(int i = startIndex ; i <= arr.length-1 ; i++){
            int val     =   Math.abs(arr[i]);
            System.out.println("val "+val+" i : "+i+" actual : "+(i-lastNegIndex) +" going to : "+(val+lastNegIndex));
            if(val + lastNegIndex > arr.length-1 || val + lastNegIndex < 0 ){
                continue;
            }

            if(val < 1){
                continue;
            }else{
                int valAtValOfArr   =   Math.abs(arr[lastNegIndex+val]);
                arr[lastNegIndex+val]   =   -valAtValOfArr;
            }
            print(arr);
        }


        int firstPositive   =   Integer.MAX_VALUE;
        for(int i = startIndex ; i <= arr.length-1;i++){
            System.out.println("i : "+i+" arr[i] : "+arr[i]);
            if(arr[i] >= 1){
                firstPositive   =   i-startIndex+1;
                break;
            }
        }
        return firstPositive == Integer.MAX_VALUE ? (arr.length-1-lastNegIndex+1) : firstPositive;
    }

    public static int shiftNegative(int[] arr){
        int lastNegIndex    =   -1;
        for(int i = 0 , j = arr.length-1 ; i <= j ;){
            if(arr[j] < 1){
                if(arr[i] > 0){
                    int temp = arr[i];
                    arr[i]  =   arr[j];
                    arr[j]  =   temp;
                }
                i++;
                lastNegIndex++;
            }else{
                j--;
            }
        }
        return lastNegIndex;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
