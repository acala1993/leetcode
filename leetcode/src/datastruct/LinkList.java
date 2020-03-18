package datastruct;

import bean.ListNode;

public class LinkList<T> {
    private ListNode head;
    private ListNode tail;

    public void insert(T val) {
        if (head == null) {
            head = tail = new ListNode(val, null);
        } else {
            tail.next = new ListNode(val, null);
            tail = tail.next;
        }
    }

    public boolean delete(T val) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while (curr != null && curr.val != val) {
            prev = curr;
            curr = curr.next;
            next = curr.next;
        }
        if (curr == null) {
            return false;
        } else {
            if (prev == null) {
                head = head.next;
            } else {
                prev.next = next;
            }
            return true;
        }
    }

    public boolean search(T val) {
        ListNode curr = head;
        while (curr != null) {
            if (isEqual((T) curr.val, val)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEqual(T val1, T val2) {
        if (val1 instanceof String) {
            return val1.equals(val2);
        } else {
            return val1 == val2;
        }
    }

}
