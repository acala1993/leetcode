package array;

import utils.ScannerUtil;

public class OneDistance {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String t = ScannerUtil.readLine();
        System.out.println(checkIfOneDistance(s, t));
    }

    public static boolean checkIfOneDistance(String s, String t) {
        int abs = Math.abs(s.length() - t.length());
        if (abs >= 2) {
            return false;
        } else if (abs == 1) {
            int i = 0;
            int j = 0;
            int diffCount = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (diffCount == 0) {
                        diffCount++;
                    } else {
                        return false;
                    }
                }
                i++;
                j++;
            }
            return i == s.length() && j == t.length();

        } else {
            int diffCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diffCount++;
                }
            }
            return diffCount == 1;
        }
    }

}
