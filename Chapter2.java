import java.util.HashSet;

public class Chapter2 {

    public static void main (String [] args) {
        // call the question
        question1();
    }

    public static void question1() {

    }

    public static void question1_execution(final LinkedListNode head) {
        LinkedListNode n = head;
        HashSet<Integer> hashSet = new HashSet<>();
        while (n.next != null) {
            if (hashSet.contains(n.next.data)) {
                n.next = n.next.next;
            } else {
                hashSet.add(n.next.data);
            }
            n = n.next;
        }
    }

    public static class LinkedListNode {
        LinkedListNode next = null;
        int data;

        public LinkedListNode(final int d) {
            data = d;
        }

        void appendToTail(final int d) {
            LinkedListNode end = new LinkedListNode(d);
            LinkedListNode n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }
    }
}
