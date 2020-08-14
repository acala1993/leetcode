package array;

import utils.ScannerUtil;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        System.out.println(findLongestSubstringWithoutRepeatingCharacters(s));
    }

    public static int findLongestSubstringWithoutRepeatingCharacters(String str) {
        int start = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if (set.isEmpty() || !set.contains(currChar)) {
                set.add(currChar);
            } else {
                maxLength = Math.max(maxLength, i - start);
                while (str.charAt(start) != currChar) {
                    set.remove(str.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return maxLength;
    }
}
