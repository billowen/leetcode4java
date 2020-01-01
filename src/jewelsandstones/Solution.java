package jewelsandstones;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        char[] j = J.toCharArray();
        for (char c : j) {
            if (S.indexOf(c) != -1) {
                result += 1;
            }
        }

        return result;
    }
}
