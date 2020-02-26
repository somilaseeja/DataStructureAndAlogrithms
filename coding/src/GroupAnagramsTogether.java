import java.util.*;

/**
 * @author SOMIL ASEEJA
 * 2020-02-25 21:13
 * Incomplete
 */
public class GroupAnagramsTogether implements Comparable<String> {

    private String str;

    public GroupAnagramsTogether(String str) {
        this.str = str;
    }

    public int hashCode(GroupAnagramsTogether gat) {
        char[] chars = gat.str.toCharArray();
        int prime = 31;
        int hashCode = 0;
        for (char curr : chars) {
            System.out.println(curr + " : " + (curr + "").hashCode());
            hashCode = hashCode + (prime * (curr + "").hashCode());
        }
        return hashCode;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof GroupAnagramsTogether))
            return false;

        GroupAnagramsTogether newO = (GroupAnagramsTogether) o;
        if (this.str.equals(newO.str))
            return true;
        else
            return false;
    }

    public String toString() {
        return this.str;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("act", "dog", "atc", "god", "cat", "odg", "tac");
        System.out.println(solveUsingHashing(list));
    }

    private static Set<String> solveUsingHashing(List<String> list) {

        List<GroupAnagramsTogether> set = new ArrayList<>();
        for (String curr : list) {
            set.add(new GroupAnagramsTogether(curr));
        }

        //Arrays.sort(set);

        return null;
    }

    @Override
    public int compareTo(String o) {
        return o.hashCode() == this.str.hashCode() ? 0 : o.hashCode() < this.str.hashCode() ? -1 : 1;
    }
}