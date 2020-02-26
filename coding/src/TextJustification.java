import java.util.ArrayList;
import java.util.List;

/**
 * @author SOMIL ASEEJA
 * 2020-02-09 23:25
 *
 * ........ NOT WORKING .......
 *
 * To justify the text so that the spaces are evenly distributed in
 * the given fixed width line.
 *
 * for ex: arr[] = {"This","is","a","simple","text","justification."}
 * max_width = 16
 *
 * output:
 * "This is a simple"
 * "text            "
 * "justification.  "
 *
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] words  =   new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        //String[] words  =   new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWidth    =   16;
        List<String> result =   fullJustify(words,maxWidth);
        for(String currLine : result){
            System.out.println(currLine);
        }
    }


    public static List<String> fullJustify(String[] words, int maxWidth) {
        String line    =   "";
        int currWidth   =   maxWidth;
        List<String> finalList  =   new ArrayList();
        List<String> currList   =   new ArrayList();
        for(int i = 0 ; i < words.length; i++){
            Boolean wordAdded  =   false;
            if(!currList.isEmpty()){
                if(words[i].length() <= (currWidth - currList.size())){
                    wordAdded   =   true;
                }
            }else{
                // Need to check if the word doesn't fits the width
                wordAdded   =   true;
            }
            System.out.println("Word : "+words[i]+ " added : "+wordAdded);
            System.out.println(currList);

            if(wordAdded){
                currList.add(words[i]);
                currWidth   =   currWidth - words[i].length();
            }else{
                int totalSize   =   0;
                //Add the currline to the line.
                for(String currWord : currList){
                    totalSize += currWord.length();
                }
                System.out.println("Total size : "+totalSize);

                int remainingWidth  =   maxWidth - totalSize - currList.size() + 1;


                int count = 0;
                for(String currWord : currList){
                    line = line + currWord;
                    if(count < currList.size()-1){

                        line    =   line + " ";
                        System.out.println("Remaining width : "+remainingWidth);
                        int addSpaces   =   remainingWidth / (currList.size()-1-count) + remainingWidth % (currList.size()-1-count);
                        remainingWidth  =   remainingWidth - addSpaces;

                        System.out.println("Add spaces :"+addSpaces);
                        for(int j = 1 ; j <= addSpaces ; j++){
                            line    =   line    +   " ";
                        }
                    }
                    count ++;
                }
                System.out.println("Final line : "+line);
                finalList.add(line);

                // Empty the list and reset currWidth
                currList.clear();
                currWidth   =   maxWidth;
                line        =   new String();

                // Add the word to the list
                currList.add(words[i]);
            }
        }
        if(!currList.isEmpty()){

            //right justify
            if(currList.size() == 1){

                line    =   line + currList.get(0);
                int addSpaces   =   maxWidth    -   currList.get(0).length();

                for(int j = 0 ; j < addSpaces ; j++){
                    line    +=  " ";
                }

            }else {

                int totalSize = 0;
                for (String currWord : currList) {
                    totalSize += currWord.length();
                }
                int remainingWidth = maxWidth - totalSize - currList.size() - 1;
                System.out.println("Rem w : " + remainingWidth);
                int count = 0;
                for (String currWord : currList) {
                    line = line + currWord;
                    if (count < currList.size()-1) {
                        line = line + " ";
                        System.out.println("Rem w : " + remainingWidth);
                        int addSpaces = remainingWidth / (currList.size() - 1 - count) + remainingWidth % (currList.size() - 1 - count);
                        remainingWidth = remainingWidth - addSpaces;
                        System.out.println("Add spaces : " + addSpaces);
                        for (int j = 1; j < addSpaces; j++) {
                            line = line + " ";
                        }
                    }
                    count++;
                }
            }
        }
        finalList.add(line);
        return finalList;
    }
}
