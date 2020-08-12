package array;

import utils.ScannerUtil;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        while (true) {
            String s = ScannerUtil.readLine();
            if ("exit".equals(s)) break;
            System.out.println(findLongestValidParentheses(s));
        }
    }

    public static int findLongestValidParentheses(String s) {
        int ret = 0;
        int curr = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    curr += 2;
                    stack.pop();
                } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    curr += 2;
                    stack.pop();
                } else {
                    ret = Math.max(ret, curr);
                    curr = 0;
                    stack.clear();
                    stack.push(c);
                }
            }
        }
        return Math.max(ret, curr);
    }

}
