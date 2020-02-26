package String;

/**
 * @author SOMIL ASEEJA
 * 2020-02-13 18:57
 *
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 *
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 */
public class GCDOfStrings {

    public static void main(String[] args) {
        String str1 =   "ABABAB";
        String str2 =   "ABAB";

        GCDOfStrings gcdOfStrings   =   new GCDOfStrings();

        System.out.println(gcdOfStrings.gcdOfStrings(str1,str2));
    }

    public String gcdOfStrings(String str1, String str2) {

        if(!(str1+str2).equals((str2+str1))){
            return "";
        }

        if(str1.equals(str2)){
            return str1;
        }

        int gcdstr  =   1;
        String substr   =   "";
        if(str1.length() > str2.length()){
            gcdstr  =   gcd(str1.length(),str2.length());
            substr  =   str2.substring(0,gcdstr);
        }else{
            gcdstr  =   gcd(str2.length(),str1.length());
            substr  =   str1.substring(0,gcdstr);
        }
        for(int i = 0 ; i < str1.length() ; i = i + gcdstr ){
            String substrInternal   =   str1.substring(i,i+gcdstr);
            if(!substrInternal.equals(substr)){
                return "";
            }
        }

        return substr;


    }

    public int gcd(int i, int j){
        if(j == 0){
            return i;
        }
        return gcd(j,i%j);
    }

}
