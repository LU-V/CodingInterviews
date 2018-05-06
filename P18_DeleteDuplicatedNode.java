package CodingInterviews;

public class P18_DeleteDuplicatedNode {
    static class Node {
        int value;
        Node next = null;

        Node(int value) {
            this.value = value;
        }
    }

        public static Node deleteDuplication(Node pHead)
        {
            Node first = new Node(-1);
            first.next = pHead;
            Node last = first;
            Node p = pHead;

            while(p!=null&&p.next!=null){
                if(p.value==p.next.value){
                    int value = p.value;
                    while(p!=null&&p.value==value){
                        p = p.next;
                        last.next = p;
                    }
                }else{
                    last = p;
                    p = p.next;
                }
            }

            return first.next;
        }


 


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(5);
        Node first = deleteDuplication(head);

        while (first != null) {
            System.out.println(first.value);
            first= first.next;
        }
    }
}
