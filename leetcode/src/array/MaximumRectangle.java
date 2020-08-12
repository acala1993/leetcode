package array;

import java.util.Stack;

public class MaximumRectangle {
    public static void main(String[] args) {
        int[] height = {1, 3, 5, 2, 0};
        System.out.println(maxRectangleInHistogram(height));
    }

    public static int maximumRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[m][n] == '0') {
                    height[m][n] = 0;
                } else {
                    height[m][n] = m == 0 ? 1 : height[m - 1][n] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, maxRectangleInHistogram(height[i]));
        }
        return max;
    }

    public static int maxRectangleInHistogram(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i++);
            } else {
                Integer end = stack.pop();
                int h = height[end];
                max = Math.max(max, h * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }


}
