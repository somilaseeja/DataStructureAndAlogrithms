package BitMasking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SOMIL ASEEJA
 * 2020-02-23 19:28
 * SO there is an array in which all number exists in pair. i.e. for a given number there will be another number
 * in an array. we need to find if there are unique numbers in the array.
 * for e.g. a[] = [1,2,3,4,5,6,4,3,2,1]
 * output = [5,6]
 * Note: You can assume that there will be only 2 unique elements in this.
 */
public class FindUniqueInArray {

    public static void main(String[] args) {

        int[] arr   =   {1,2,3,4,5,6,4,3,2,1};
        //System.out.println(1^2);
        System.out.println(findUnique(arr));

    }

    private static List<Integer> findUnique(int[] arr) {

        List<Integer> finalList =   new ArrayList<>();

        int res =   0;
        for(int i =0;i<arr.length;i++){
            res =   res^arr[i];
        }

        int i=0,temp=res;
        while(temp>0){
            if(((int)temp&1)==1){
                break;
            }
            i++;
            temp    =   temp>>1;
        }

        int mask    =   1<<i;

        int firstNum    =   0;
        for(int j = 0;j<arr.length;j++){
            if((mask&arr[j])!=0){
                firstNum    =   firstNum^arr[j];
            }
        }

        finalList.add(firstNum);

        finalList.add(firstNum^res);

        return finalList;
    }

}
