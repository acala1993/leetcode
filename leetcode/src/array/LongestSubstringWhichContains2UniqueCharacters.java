package array;

import utils.ScannerUtil;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWhichContains2UniqueCharacters {
    public static void main(String[] args) {
        String str = ScannerUtil.readLine();
        System.out.println(findLongestSubstringWith2UniqueCharacters(str));
    }

    public static String findLongestSubstringWith2UniqueCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();
        String result = "";
        int left = 0;
        for (int curr = 0; curr < str.length(); curr++) {
            char currChar = str.charAt(curr);
            if (map.containsKey(currChar)) { // 非新元素情况
                map.put(currChar, map.get(currChar) + 1);
            } else { // 新元素的时候
                if (map.keySet().size() == 2) { // 处理超过两个元素的情况
                    while (map.keySet().size() == 2) {
                        if (result.length() < curr - left) {
                            result = str.substring(left, curr);
                        }
                        char delChar = str.charAt(left);
                        Integer count = map.get(delChar);
                        count = count - 1;
                        if (count == 0) {
                            map.remove(delChar);
                        } else {
                            map.put(delChar, count);
                        }
                        left++;
                    }
                    map.put(currChar, 1);
                } else {
                    map.put(currChar, 1);
                }
            }
        }
        return result;
    }

}
