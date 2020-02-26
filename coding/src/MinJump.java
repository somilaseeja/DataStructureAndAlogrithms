/**
 * @author SOMIL ASEEJA
 * 2020-02-19 11:54
 */
public class MinJump {

    public static void main(String[] args) {
        MinJump minJump    =    new MinJump();
        int[] arr          =    {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJump.minJumps(arr));
    }

    public int minJumps(int[] arr) {
        int length  =   arr.length;
        if(length == 1){
            return 0;
        }else if(length == 2){
            return 1;
        }
        int i = 0;
        int j = length-1;
        if(arr[i] == arr[j]){
            return 1;
        }

        int steps   =   0;
        while(i != length-1){
            for(j=  length-1;j > i;j--){
                //System.out.println("i : "+i+" j "+j+" steps : "+steps+" arr[i] "+arr[i]+" arr[j] "+arr[j]);
                if((i-1) >= 0 && arr[i-1] == arr[j]){
                    i   =   i - 1;
                    break;
                }else if(arr[i] == arr[j]){
                    i = j;
                    break;
                }else if((i+1) <= (length -1) && arr[i+1] == arr[j]){
                    i++;
                    break;
                }
            }
            steps++;
        }
        return steps;
    }

}
