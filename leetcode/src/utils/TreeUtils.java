package utils;

import bean.TreeNode;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeUtils {
    public static List<Object> preOrderByReverse(TreeNode head, boolean needReturn) {
        List<Object> ret = null;
        if (needReturn) {
            ret = new ArrayList<>();
        }
        preOrderByReverseWithReturn(head, ret);
        return ret;
    }

    public static void preOrderByReverseWithReturn(TreeNode head, @Nullable List<Object> ret) {
        if (head != null) {
            if (ret != null) {
                ret.add(head.val);
            } else {
                System.out.println(head.val);
            }
            preOrderByReverseWithReturn(head.left, ret);
            preOrderByReverseWithReturn(head.right, ret);
        }
    }

    public static List<Object> inOrderByReverse(TreeNode head, boolean needReturn) {
        List<Object> ret = null;
        if (needReturn) {
            ret = new ArrayList<>();
        }
        inOrderByReverseWithReturn(head, ret);
        return ret;
    }

    public static void inOrderByReverseWithReturn(TreeNode head, List<Object> ret) {
        if (head != null) {
            inOrderByReverseWithReturn(head.left, ret);
            if (ret != null) {
                ret.add(head.val);
            } else {
                System.out.println(head.val);
            }
            inOrderByReverseWithReturn(head.right, ret);
        }
    }

    public static List<Object> postOrderByReverse(TreeNode head, boolean needReturn) {
        List<Object> ret = null;
        if (needReturn) {
            ret = new ArrayList<>();
        }
        postOrderByReverseWithReturn(head, ret);
        return ret;
    }

    public static void postOrderByReverseWithReturn(TreeNode head, List<Object> ret) {
        if (head != null) {
            postOrderByReverseWithReturn(head.left, ret);
            postOrderByReverseWithReturn(head.right, ret);
            if (ret != null) {
                ret.add(head.val);
            } else {
                System.out.println(head.val);
            }
        }
    }

    public static List<Object> preOrder(TreeNode head, boolean needReturn) {
        List<Object> ret = null;
        if (needReturn) {
            ret = new ArrayList<>();
        }
        TreeNode curr = head;
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            while (!stack.empty()) {
                TreeNode temp = stack.pop();
                if (ret != null) {
                    ret.add(temp.val);
                } else {
                    System.out.println(temp.val);
                }
                if (temp.right != null) {
                    curr = temp.right;
                    break;
                }
            }
        }
        return ret;
    }

    public static List<Object>

}
