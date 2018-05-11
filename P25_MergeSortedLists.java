package CodingInterviews;

public class P25_MergeSortedLists {
    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int data) {
            this.value = data;
        }
    }


    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode pMergeHead = null;
        if (list1.value < list2.value) {
            pMergeHead = list1;
            pMergeHead.next = Merge(list1.next, list2);
        } else {
            pMergeHead = list2;
            pMergeHead.next = Merge(list1, list2.next);
        }
        return pMergeHead;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        list2.next.next.next = new ListNode(8);

        ListNode m = Merge(list1, list2);
        while (m != null) {

            System.out.println(m.value);
            m = m.next;
        }
    }
}