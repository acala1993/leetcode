package string;

import utils.ScannerUtil;

public class ShortestPalindrome {
    public static void main(String[] args) {
        String line = ScannerUtil.readLine();
        System.out.println(findShortestPalindrome(line));
    }

    private static String findShortestPalindrome(String line) {
        int left = 0;
        int right = line.length() - 1;
        while (right >= 0) {
            if (line.charAt(left) == line.charAt(right)) {
                left++;
            }
            right--;
        }
        String reverse = new StringBuilder(line.substring(left)).reverse().toString();
        return reverse + line;
    }
}
