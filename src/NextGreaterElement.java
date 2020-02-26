import java.util.Stack;

/**
 * @author SOMIL ASEEJA
 * 2020-02-23 21:46
 * Ques: https://practice.geeksforgeeks.org/problems/next-larger-element/0
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr   =   {1,3,2,4};
        //output = {3,4,4,-1}
        System.out.println(solve(arr));
    }

    public static String solve(int[] arr){

        if(arr.length   ==  1){
            return -1+"";
        }

        Stack<Integer> stack    =   new Stack<>();
        stack.push(arr[0]);
        String str  =   "";
        for(int i = 1 ; i < arr.length; i++){
            System.out.println(stack);
            int top =   stack.peek();
            if(arr[i] > top){
                while(!stack.isEmpty() && stack.peek() < arr[i]){
                    System.out.println(stack.peek()+"  -> "+arr[i]);
                    stack.pop();
                    //stack.push(arr[i]);
                    str += arr[i] + " ";
                }
                stack.push(arr[i]);
            }else{
                stack.push(arr[i]);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop()+"  -> -1");
            str += "-1 ";
        }
        return str;
    }

}
