package array;

import utils.PrintUtils;
import utils.ScannerUtil;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = ScannerUtil.readArray();
        int k = ScannerUtil.readInt();
        PrintUtils.printIntList(findTopKFrequentElements(arr, k));
    }

    static class node {
        int value;
        int count;

        public node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static List<Integer> findTopKFrequentElements(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        PriorityQueue<node> priorityQueue = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.count - o2.count;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(new node(entry.getKey(), entry.getValue()));
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().value);
        }
        Collections.reverse(result);
        return result;
    }

}
