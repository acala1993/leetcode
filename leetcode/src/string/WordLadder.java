package string;

import utils.ScannerUtil;

import java.util.*;

public class WordLadder {
    private static int minLength = -1;
    private static List<List<String>> minLengthPaths = new ArrayList<>();

    public static void main(String[] args) {
        String origin = ScannerUtil.readLine();
        String dest = ScannerUtil.readLine();
        String[] strings = ScannerUtil.readStringArray();
//        System.out.println(wordLadderI(origin, dest, strings));
        System.out.println(wordLadderII(origin, dest, strings));
    }

    private static class Node {
        Node prev;
        String val;

        public Node(String val, Node prev) {
            this.prev = prev;
            this.val = val;
        }

    }

    public static int wordLadderI(String origin, String dest, String[] strings) {
        Queue<String> queue = new LinkedList<>();
        queue.add(origin);
        int currCount = 1;
        int nextCount = 0;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            for (int i = 0; i < currCount; i++) {
                String curr = queue.remove();
                if (canTraverse(curr, dest)) {
                    return step + 1;
                } else {
                    for (int j = 0; j < strings.length; j++) {
                        if (canTraverse(curr, strings[j])) {
                            nextCount++;
                            queue.add(strings[j]);
                        }
                    }
                }
            }
            currCount = nextCount;
            nextCount = 0;
        }
        return -1;
    }

    public static List<List<String>> wordLadderII(String origin, String target, String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(origin, null);
        int currCount = 1;
        int nextCount = 0;
        queue.add(node);
        while (!queue.isEmpty()) {
            boolean flag = false;
            for (int i = 0; i < currCount; i++) {
                Node curr = queue.remove();
                if (canTraverse(curr.val, target)) {
                    List<String> path = new ArrayList<>();
                    path.add(target);
                    while (curr != null) {
                        path.add(curr.val);
                        curr = curr.prev;
                    }
                    Collections.reverse(path);
                    result.add(path);
                    flag = true; // 更新在当前层是否找到结果标志位
                } else {
                    for (String string : strings) {
                        if (canTraverse(curr.val, string)) {
                            queue.add(new Node(string, curr));
                            nextCount++;
                        }
                    }
                }
            }
            if (flag) { // 剪枝
                break;
            }
            currCount = nextCount;
            nextCount = 0;
        }
        return result;
    }

    public static boolean canTraverse(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

}
