package CodingInterviews;

public class P18_DeleteNodeInList {
    public static class Node {
        Node next;
        int value;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void DeleteNode(Node headNode, Node deleteNode) {
        if (headNode == null || deleteNode == null) {
            return;
        }

        if (deleteNode.next != null){ // 链表有多个节点，要删除的不是尾节点:O(1)时间
            Node tempNode = deleteNode.next;
            deleteNode.value = tempNode.value;
            deleteNode.next = tempNode.next;
            tempNode = null;
        } else if (headNode == deleteNode){ // 链表只有一个结点，删除头结点（也是尾结点）:O(1)时间
            deleteNode = null;
            headNode = null;
        } else{ // 链表有多个节点，要删除的是尾节点:O(n)时间
            Node tempNode = headNode;
            while (tempNode.next != deleteNode) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            deleteNode = null;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        DeleteNode(head,head.next.next);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

}
