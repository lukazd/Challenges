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

    public static void question2() {

    }

    public static Integer question2_execution(final LinkedListNode head, int k) {
        LinkedListNode first = head;
        LinkedListNode second = head;
        for (int i = 0; i < k - 2; ++i) {
            if (first.next == null) {
                return null;
            }

            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;
    }

    public static void question3() {

    }

    public static void question3_execution(final LinkedListNode middle) {
        middle.data = middle.next.data;
        middle.next = middle.next.next;
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
