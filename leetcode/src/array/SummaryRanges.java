package array;

import utils.ArrayUtil;
import utils.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] array = ArrayUtil.str2Array(ScannerUtil.readLine());
        List<String> ret = getSummaryRanges(array);
        for (String s : ret) {
            System.out.print(s + '\t');
        }
    }

    public static List<String> getSummaryRanges(int[] arr) {
        List<String> ret = new ArrayList<>();
        int left = 0;
        for (int i = 1; i <= arr.length; i++) {
            if (i == arr.length || arr[i] != arr[i - 1] + 1) {
                if (i - 1 == left) {
                    ret.add(new StringBuilder().append(arr[left]).toString());
                } else {
                    ret.add(new StringBuilder().append(arr[left]).append(arr[i - 1]).toString());
                }
                left = i;
            }
        }
        return ret;
    }
}
