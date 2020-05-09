package array;

import utils.ScannerUtil;

public class ShortestWordDistance {
    public static void main(String[] args) {
        String[] strings = ScannerUtil.readStringArray();
        String s = ScannerUtil.readLine();
        String t = ScannerUtil.readLine();
        System.out.println(findShortestWordDistanceII(s, t, strings));
    }

    public static int findShortestWordDistance(String s, String t, String[] strings) {
        int ret = Integer.MAX_VALUE;
        int lastIndex = -1;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].endsWith(s) || strings[i].endsWith(t)) {
                if (lastIndex == -1) {
                    lastIndex = i;
                } else {
                    if (strings[lastIndex].equals(strings[i])) {
                        lastIndex = i;
                    } else {
                        ret = Math.min(ret, i - lastIndex);
                    }
                }
            }
        }
        return ret;
    }

    public static int findShortestWordDistanceII(String s, String t, String[] strings) {
        int ret = Integer.MAX_VALUE;
        int lastIndex = -1;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].endsWith(s) || strings[i].endsWith(t)) {
                if (lastIndex == -1) {
                    lastIndex = i;
                } else {
                    if (strings[lastIndex].equals(strings[i]) && s.equals(t)
                            || !strings[lastIndex].equals(strings[i]) && !s.equals(t)) {
                        ret = Math.min(ret, i - lastIndex);
                    } else {
                        lastIndex = i;
                    }
                }
            }
        }
        return ret;
    }
}
