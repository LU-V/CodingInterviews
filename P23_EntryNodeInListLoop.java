package CodingInterviews;

public class P23_EntryNodeInListLoop {
    static class Node {
        Node next;
        int value;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node EntryNodeListLoop(Node head) {
        int count = 1;
        if (head == null) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        while (true) {//找到循环部分结点的个数
            if (p1.next.next==null||p1.next==null||p2.next==null){
                return null;
            }
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                p1 = p1.next;
                while (p1.next != null) {
                    if (p1 != p2) count++;
                    else break;
                    p1 = p1.next;
                }
                break;
            }
        }
        p1 = head;
        p2 = head;
        for (int i = count; count > 0; count--) {
            p1 = p1.next;
        }
        while (p1.next != null || p1.next != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;

        }

        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next.next ;

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next=null;
        if (EntryNodeListLoop(head)==null){
            System.out.println("null");
        }else {
            System.out.println(EntryNodeListLoop(head).value);
        }

        if (EntryNodeListLoop(head1)==null){
            System.out.println("null");
        }else {
            System.out.println(EntryNodeListLoop(head1).value);
        }

    }
}