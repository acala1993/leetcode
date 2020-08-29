package array;

import utils.ScannerUtil;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String t = ScannerUtil.readLine();
        System.out.println(isMatching(s, t));
    }

    public static boolean isMatching(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '.' || t.charAt(i) == s.charAt(0)) {
                if (isMatching(s, t, 0, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMatching(String s, String t, int sIndex, int tIndex) {
        int i = sIndex;
        int j = tIndex;
        Character lastElem = null; // 记录上次出现*,*之前的元素
        int lastSIndex = -1; // 记录上次出现*,匹配s的下标
        int lastTIndex = -1; // 记录上次出现*在t中的位置
        while (i < s.length()) {
            if (j < t.length() && (t.charAt(j) == s.charAt(i) || t.charAt(j) == '.')) {
                i++;
                j++;
            } else if (j < t.length() && t.charAt(j) == '*') {
                // TODO 两个连续*的情况
                lastElem = t.charAt(j - 1);
                lastTIndex = j;
                lastSIndex = i;
                j++; // *默认匹配0个字符
            } else if (lastSIndex != -1) {
                if (lastElem == '.' || lastElem == s.charAt(i)) {
                    i = lastSIndex + 1;
                    lastSIndex++;
                    j = lastTIndex + 1;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
