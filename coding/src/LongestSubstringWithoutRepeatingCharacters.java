import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author SOMIL ASEEJA
 * 2020-02-25 21:42
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //String s    =   "abcabcab";
        //String s    =   "bbbbb";
        String s    =   "pwwkew";
        usingSet2(s);

    }

    public static int usingSet(String s){
        int i   =   0;
        int j   =   0;
        int max =   0;
        Set<Character> set  =   new LinkedHashSet<>();
        while(j < s.length()){

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max =   Math.max(set.size(),max);
                System.out.println(set);
            }else{
                System.out.println("before removing");
                System.out.println(set);
                set.remove(s.charAt(i));
                System.out.println("After");
                System.out.println(set);
                i++;
            }
        }
        System.out.println(set+" "+set.size());
        return set.size();
    }

    public static int usingSet2(String s){
        //int i = 0;
        int j = 0;
        int max =   0;
        Set<Character> set  =   new LinkedHashSet<>();
        Set<Character> maxSet   =   null;

        while(j < s.length()){
            if(!(set.contains(s.charAt(j)))){
                set.add(s.charAt(j));
                j++;
                max =   Math.max(set.size(),max);
                maxSet  =   new LinkedHashSet<>(set);
                System.out.println(set+" "+max);
            }else{
                set.clear();
                set.add(s.charAt(j));
                j++;
            }
        }
        System.out.println(maxSet+" "+max);
        return set.size();
    }

}
