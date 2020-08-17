package array;

import utils.ScannerUtil;

import java.util.*;
import java.util.stream.Stream;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = ScannerUtil.readLine();
        String[] strings = ScannerUtil.readStringArray();
        List<Integer> list = findIndex(s, strings);
        Stream.of(list).forEach(System.out::println);
    }

    public static List<Integer> findIndex(String s, String[] strings) {
        List<Integer> result = new ArrayList<>();
        Set<String> originSet = new HashSet<>();
        for (String string : strings) {
            originSet.add(string);
        }
        Set<String> countSet = new HashSet<>();
        int length = strings[0].length();
        int count = strings.length;
        for (int i = 0; i < s.length() - count * length + 1; i++) {
            int start = i;
            while (start < s.length()) {
                String substring = s.substring(start, start + 3);
                if (originSet.contains(substring)) {
                    if (countSet.contains(substring)) {
                        break;
                    } else {
                        countSet.add(substring);
                        // 判断容器size
                        if (countSet.size() == strings.length) {
                            result.add(i);
                            break;
                        }
                        start = start + 3;
                    }
                } else {
                    break;
                }
            }
            countSet.clear();
        }
        return result;
    }

}
