import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author SOMIL ASEEJA
 * 2020-02-20 11:05
 */
public class Neeraj {
    public static void main(String[] args) {
        //char[] arr  =   {'a','a','b','a','b','a','a'};
        char[] arr  =   {'a','a'};
        int k   =   2;
        System.out.println(time(arr,k));
    }

    public static int time(char[] arr, int k){
        if(arr.length   ==  1){
            return 1;
        }
        Map<Character,Integer> lastOcc  =   new HashMap();
        int totalTime   =   0;
        for(int i = 0 ; i < arr.length ; i++){
            if(lastOcc.containsKey(arr[i]) && (i-arr[i] <= k)){
                totalTime   +=  (k-i+lastOcc.get(arr[i])) + 1;
            }
            totalTime += 1;
            lastOcc.put(arr[i],i);
        }


        return totalTime;
    }
}
