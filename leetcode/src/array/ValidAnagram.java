package array;

import utils.ScannerUtil;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        String[] strings = ScannerUtil.readStringArray();
        Collection<List<String>> ret = groupShiftedStrings(strings);
        System.out.println(ret);
    }

    public static Collection<List<String>> groupShiftedStrings(String[] strings) {
        Map<String, List<String>> result = new HashMap<>();
        for (String string : strings) {
            if (result.isEmpty()) {
                List<String> value = new ArrayList<>();
                value.add(string);
                result.put(string, value);
            } else { // map中已有元素，可能需要添加到已有元素集合中
                Set<String> keySet = result.keySet();
                boolean flag = false;
                for (String s : keySet) {
                    if (isShiftedString(s, string)) {
                        result.get(s).add(string);
                        flag = true;
                    }
                }
                if (!flag) {
                    List<String> value = new ArrayList<>();
                    value.add(string);
                    result.put(string, value);
                }
            }
        }
        return result.values();
    }

    public static boolean isShiftedString(String origin, String dest) {
        if (origin.length() != dest.length()) return false;
        else {
            if (origin.length() == 1) {
                return true;
            } else {
                for (int i = 1; i < origin.length(); i++) {
                    int originDiff = (int)origin.charAt(i) - (int)origin.charAt(i - 1);
                    if (originDiff <0) {
                        originDiff +=26;
                    }
                    int destDiff = (int)dest.charAt(i) - (int)dest.charAt(i - 1);
                    if (destDiff <0) {
                        destDiff +=26;
                    }
                    if (originDiff != destDiff) return false;
                }
                return true;
            }
        }
    }


}
