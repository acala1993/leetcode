package bean;

public class DubbleListNode<T> {
    public T val;
    public DubbleListNode prev;
    public DubbleListNode next;

    public DubbleListNode(T val, DubbleListNode prev, DubbleListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
