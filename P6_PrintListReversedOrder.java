package CodingInterviews;

import java.util.Stack;

public class P6_PrintListReversedOrder {
    static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value=data;
        }
    }
    public static void reversed1(Node list){
        Stack nodes= new Stack();
        while(list!=null){
            nodes.push(list.value);
            list = list.next;
        }
        while (!nodes.isEmpty()){
            System.out.println(nodes.pop());
        }
    }
    public static void reversed2(Node list){
        if(list.next==null){
            System.out.println(list.value);
            return;
        }
        reversed2(list.next);
        System.out.println(list.value);
        return;
    }


    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);
        reversed2(node1);
        //reversed2(node1);
    }
}
