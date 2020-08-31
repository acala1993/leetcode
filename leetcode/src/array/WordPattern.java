package array;

import utils.ScannerUtil;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = ScannerUtil.readLine();
        String s = ScannerUtil.readLine();
        System.out.println(checkWordPatternII(pattern, s));
    }

    public static boolean checkWordPatternI(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (map.containsKey(curr)) {
                if (!map.get(curr).equals(strings[i])) {
                    return false;
                }
            } else {
                map.put(curr, strings[i]);
            }
        }
        return true;
    }

    public static boolean checkWordPatternII(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        return check(pattern, s, 0, 0, map);
    }

    public static boolean check(String pattern, String s, int pIndex, int sIndex, Map<Character, String> map) {
        if (sIndex == s.length() && pIndex == pattern.length()) {
            return true;
        }
        if (sIndex == s.length() || pIndex == pattern.length()) {
            return false;
        }
        char curr = pattern.charAt(pIndex);
        if (map.containsKey(curr)) {
            String value = map.get(curr);
            if (value != null && sIndex + value.length() <= s.length() && value.equals(s.substring(sIndex, sIndex + value.length()))) { // 如果能够匹配下一个单词，则继续深度优先搜索
                return check(pattern, s, pIndex + 1, sIndex + value.length(), map);
            } else {
                return false;
            }
        } else {
            for (int i = sIndex + 1; i <= s.length(); i++) {
                map.put(curr, s.substring(sIndex, i));
                if (check(pattern, s, pIndex + 1, i, map)) {
                    // 剪枝优化
                    return true;
                } else {
                    map.remove(curr);
                }
            }
            return false;
        }

    }


}
