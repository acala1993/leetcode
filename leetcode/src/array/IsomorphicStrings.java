package array;

import utils.ScannerUtil;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String t = ScannerUtil.readLine();
        System.out.println(isomorphicStrings(s, t));
    }

    public static boolean isomorphicStrings(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] origin = s.toCharArray();
        char[] dest = t.toCharArray();
        for (int i = 0; i < origin.length; i++) {
            char originChar = origin[i];
            char destChar = dest[i];
            if (map.containsKey(originChar)) {
                if (map.get(originChar) != destChar) {
                    return false;
                }
            } else {
                map.put(originChar, destChar);
            }
        }
        return true;
    }
}
