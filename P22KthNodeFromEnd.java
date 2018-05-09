package CodingInterviews;

public class P22KthNodeFromEnd {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0 || head == null) {

            return null;
//            System.out.println("Error");
        }

        int p1 = 0;
        int p2 = 0;
        ListNode c = head;
        while (head.next != null) {
            head = head.next;
            p1++;
            if (p1 > k - 1) {
                p2++;
                c = c.next;
            }
        }
        if (p2 == 0 && p1 != k - 1) {
            return null;
        }

        return c;
    }

    public static ListNode FindKthToTail2(ListNode head, int k) {
        if (k <= 0 || head == null) {

            return null;
        }
        ListNode p1 = head;
        ListNode p2 = null;
        for (int i = 0; i < k - 1; i++) {
            if (p1.next == null) {

                return null;
            }
            p1 = p1.next;
        }
        p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(FindKthToTail(head, 0));
        System.out.println(FindKthToTail(head, 3).val);
        System.out.println(FindKthToTail(head, 6));
        System.out.println("----------------------------------------------");
        System.out.println(FindKthToTail2(head, 0));
        System.out.println(FindKthToTail2(head, 3).val);
        System.out.println(FindKthToTail2(head, 6));
//        FindKthToTail1(head,5);
//        FindKthToTail1(head,2);

    }
}
