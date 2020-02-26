package Array; /**
 * @author SOMIL ASEEJA
 * 2020-02-12 19:13
 */

/**
 *  Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * EXAMPLE
 * Input: "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {

    public static void main(String[] args) {
        String string   =   "Mr John Smith    ";
        char[] strArr   =   string.toCharArray();
        System.out.println(urlify(strArr));

    }

    public static String urlify(char[] arr){
        if(arr.length   ==  0){
            return "";
        }

        int lastCharIndex   =   findLastChar(arr);
        System.out.println("LastCharIndex : "+lastCharIndex);
        int lastIndex       =   arr.length-1;

        for(int i = lastCharIndex ; i >=0 ; i--){

            if(arr[i] == ' '){
                arr[lastIndex]      =   '0';
                arr[lastIndex-1]    =   '2';
                arr[lastIndex-2]    =   '%';
                lastIndex           =   lastIndex-3;
            }else{
                arr[lastIndex]      =   arr[i];
                lastIndex--;
            }

        }

        return new String(arr);

    }

    private static int findLastChar(char[] arr){
        for(int i = arr.length-1; i>=0 ; i--){
            if(arr[i] != ' '){
                return i;
            }
        }
        return -1;
    }

}
