package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SOMIL ASEEJA
 * 2020-02-12 19:40
 *
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 *
 */
public class OneAway {

    public static void main(String[] args) {

        String s1   =   "pale";
        String s2   =   "pla";
        System.out.println(s1+" , "+s2+" -> "+check(s1,s2));
    }

    public static boolean check(String s1, String s2){

        char[] c1   =   s1.toCharArray();
        char[] c2   =   s2.toCharArray();

        if((c1.length - c2.length) > 1){
            return false;
        }

        int count   =   0;

        Set<Character> resultant   =   new HashSet<>();
        for(int i = 0; i < c1.length; i++){
            resultant.add(c1[i]);
        }

        for(int i = 0; i < c2.length; i++){
            if(!resultant.add(c2[i])){
                count++;
            }
        }

        return Math.abs(count-s1.length()) <= 1;
    }

}
