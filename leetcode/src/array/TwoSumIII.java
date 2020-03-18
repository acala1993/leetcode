package array;

public class TwoSumIII {
    private static ListNode head;

    public static void main(String[] args) {

    }

    public static void add(int i) {
        if (head == null) {
            head = new ListNode(i, null);
        } else {
            if (i < head.val) {
                head = new ListNode(i, head);
            } else {
                ListNode temp = head.next;
                while (temp.next != null && temp.val < i) {
                    temp = temp.next;
                }
                temp.next = new ListNode(i, temp.next);
            }
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int n, ListNode node) {
            this.val = n;
            this.next = node;
        }
    }
}
