package CodingInterviews;

public class P24_ReverseList {
    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int data) {
            this.value = data;
        }
    }
    public static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode  next = null;
        while (head!=null){
            next = head.next;
            head.next= pre;
            pre = head;
            head = next;
        }
        return pre;
    }
//recursive
    public static ListNode reverse1(ListNode head){
        if(head==null||head.next ==null)
            return head;
        ListNode pre = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode pre =reverse1(head);
        if (pre!=null){
            while (pre!=null){
                System.out.println(pre.value);
                pre=pre.next;
            }
        }else {
            System.out.println("null");

        }



    }

}
