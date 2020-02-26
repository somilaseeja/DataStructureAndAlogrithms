/**
 * @author SOMIL ASEEJA
 * 2020-02-25 20:50
 * Ques : https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 *   3-way partition
 *
 */
public class DutchNationalFlagOr012Separation {

    public static void main(String[] args) {

        int[] arr   =   {0,1,1,0,1,1,2,0,1,1,2,1};

        solve(arr);

        for(int a : arr){
            System.out.print(a+" ");
        }

    }

    private static void solve(int[] arr) {

        int low = 0,mid=0,hi=arr.length-1;

        while(mid<=hi){

            switch (arr[mid]){
                case 0: {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    int temp = arr[hi];
                    arr[hi] = arr[mid];
                    arr[mid] = temp;
                    hi--;
                }
            }
        }

    }

}
