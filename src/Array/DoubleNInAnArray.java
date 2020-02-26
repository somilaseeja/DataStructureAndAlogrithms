package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SOMIL ASEEJA
 * 2020-02-14 11:25
 *
 * Check if an array consist of two element i and j such that i = 2 * j;
 * e.g. [10,2,5,11]
 * return true as i = 5 and j = 10;
 */
public class DoubleNInAnArray {

    public static void main(String[] args) {

        DoubleNInAnArray    d   =   new DoubleNInAnArray();
        int[] arr               =   {10,2,5,3};
        //int[] arr             =   {7,1,14,11};
        System.out.println(d.checkIfExist(arr));

    }

    public boolean checkIfExist(int[] arr) {
        //Arrays.sort(arr);
        Set<Integer> halvedSet  =   new HashSet();
        Boolean found   =   false;
        if(arr.length < 2){
            return found;
        }

        for(int i = 0; i < arr.length ; i++){
            if(arr[i] % 2 == 0){
                if(halvedSet.contains(arr[i] /2)){
                    found   =   true;
                    break;
                }
            }
            if(halvedSet.contains(arr[i] *2)){
                found   =   true;
                break;
            }

            halvedSet.add(arr[i]);
        }
        return found;
    }
}