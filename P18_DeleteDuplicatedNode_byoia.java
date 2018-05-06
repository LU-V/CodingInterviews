package CodingInterviews;

public class P18_DeleteDuplicatedNode_byoia {

    public static class Node{
        Node next;
        int value;
        public Node(int data){
            this.value=data;
        }
    }

    public static Node deleteDuplication( Node head){
        if(head==null){
            return head;
        }
        Node first = new Node(-1);
        first.next=head;
        Node cur = first.next;
        Node p = first;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.next.value==p.next.value){
                int v = p.next.value;
                while(p.next.value==v){
                    p.next=cur.next;
                    cur=cur.next;
                }

            }else{
                p=cur;
                cur=cur.next;
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


