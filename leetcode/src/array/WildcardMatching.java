package array;

import utils.ScannerUtil;

public class WildcardMatching {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String t = ScannerUtil.readLine();
        System.out.println(checkIfWildcardMatching(s, t));
    }

    public static boolean checkIfWildcardMatching(String s, String p) {
        int i = 0;
        int j = 0;
        int lastIndex = -1; // 指向上个*
        int iIndex = -1; // 指向s中上个*匹配的字符
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                // 默认匹配空串
                lastIndex = j;
                iIndex = i - 1;
                j++;
            } else if (lastIndex != -1) {
                // 可能之前*号匹配有误，增加*匹配字符
                iIndex = iIndex + 1;
                i = iIndex + 1;
                j = lastIndex + 1;
            } else return false;
        }
        while (j < p.length()) {
            if (p.charAt(j) == '*') {
                j++;
            }
        }
        return j == p.length();
    }


}
