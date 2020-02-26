import java.util.Stack;

/**
 * @author SOMIL ASEEJA
 * 2020-02-13 22:18
 *
 * Find the largest rectangular area possible in a given histogram
 * where the largest rectangle can be made of a number of contiguous bars.
 * For simplicity, assume that all bars have same width and the width is 1 unit.
 * For example, consider the following histogram with 3 bars of
 * heights {2,1,3}.
 * The largest possible rectangle possible is 3.
 *
 * Find Quest : https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * Ref :
 */
public class MaxReactangleHistogramArea {

    public static int maxArea(int[] arr){

        Stack<Integer> stack    =   new Stack<>();
        int maxArea             =   0;
        int i                   =   0;
        for(; i < arr.length;){

            if(stack.isEmpty() || arr[stack.peek()] <= arr[i]){
                stack.push(i);
                i++;
            }else{
                int top = stack.pop();
                int currMax =   0;
                if(stack.isEmpty()){
                    currMax =   arr[top] * i;
                }else{
                    currMax =   arr[top] * (i - stack.peek() - 1);
                }
                if(currMax > maxArea){
                    maxArea =   currMax;
                }
            }
        }

        while(!stack.isEmpty()){
            int currMax =   0;
            int top = stack.pop();
            if(stack.isEmpty()){
                currMax =   arr[top] * i;
            }else{
                currMax =   arr[top] * (i - stack.peek() - 1);
            }
            if(currMax > maxArea){
                maxArea =   currMax;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr   =   {2,2,3,2};
        System.out.println(maxArea(arr));
    }
}
