package string;

import utils.ScannerUtil;

import java.util.HashSet;
import java.util.Set;

public class ScrambleString {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String t = ScannerUtil.readLine();
        System.out.println(checkIfScramble(s, t));
    }

    public static boolean checkIfScramble(String s, String t) {
        if (s.length() == 1 && s.equals(t)) {
            return true;
        }
        if (s.length() == 2 && hasSameChar(s, t)) {
            return true;
        }

        for (int i = 1; i < s.length(); i++) {
            if (checkIfScramble(s.substring(0, i), t.substring(0, i))
                    && checkIfScramble(s.substring(i), t.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSameChar(String s, String t) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : t.toCharArray()) {
            if (!set.contains(c)) return false;
        }
        return true;
    }
}
