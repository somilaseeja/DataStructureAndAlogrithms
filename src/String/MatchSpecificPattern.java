package String;

import java.util.*;

/**
 * @author SOMIL ASEEJA
 * 2020-02-15 18:29
 *
 * Quesrtion: https://practice.geeksforgeeks.org/problems/match-specific-pattern/1
 */
public class MatchSpecificPattern {

    public static void main(String[] args) {
        ArrayList<String> dict   =   new ArrayList<>();
        dict.add("abb");
        dict.add("abc");
        dict.add("xyy");
        dict.add("xyz");
        String pattern  =   "foo";

        MatchSpecificPattern m  =   new MatchSpecificPattern();
        System.out.println(m.patternMatching(dict,pattern));

    }

    private ArrayList<String> patternMatching(ArrayList<String> dict, String pattern){
        char[] charPatt             =   pattern.toCharArray();
        ArrayList<String> result    =   new ArrayList();
        StringBuilder finalStr      =   new StringBuilder();
        Boolean found               =   false;
        for(int i = 0; i < dict.size() ; i++){
            if(dict.get(i).length() != pattern.length()){
                continue;
            }
            found   =   true;
            Map map =   new HashMap();
            char[] charArrDict  =   dict.get(i).toCharArray();
            for(int j = 0; j < charPatt.length ; j++){
                if(map.containsKey(charPatt[j])){
                    if((Character) map.get(charPatt[j]) != charArrDict[j]){
                        found   =   false;
                        break;
                    }
                }else{
                    map.put(charPatt[j],charArrDict[j]);
                }

            }
            if(found){
                result.add(dict.get(i));
            }

        }

        return result;
    }
}
