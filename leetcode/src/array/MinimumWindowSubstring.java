package array;

import utils.ScannerUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String t = ScannerUtil.readLine();
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        String result = "";
        Set<Character> originSet = new HashSet<>();
        for (char c : t.toCharArray()) {
            originSet.add(c);
        }
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (originSet.contains(currChar)) {
                if (!countMap.containsKey(currChar)) {
                    countMap.put(currChar, 1);
                    if (countMap.size() == t.length()) {
                        if (result.equals("") || result.length() > i - left + 1) {
                            result = s.substring(left, i + 1); // 更新最小窗口字符串
                        }
                        // 更新左边界下标
                        while (countMap.size() == t.length() && left < i) {
                            char delChar = s.charAt(left);
                            if (originSet.contains(delChar)) {
                                int count = countMap.get(delChar) - 1;
                                if (count == 0) {
                                    countMap.remove(delChar);
                                }
                            }
                            left++;
                        }
                        // 左边界一定指向一个模板元素
                        while (left < i && !originSet.contains(s.charAt(left))) {
                            left++;
                        }
                    }
                } else {
                    countMap.put(currChar, countMap.get(currChar) + 1);
                }
            }
        }
        return result;
    }

}
