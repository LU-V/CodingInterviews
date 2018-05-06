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

        if (deleteNode.next != null){ // �����ж���ڵ㣬Ҫɾ���Ĳ���β�ڵ�:O(1)ʱ��
            Node tempNode = deleteNode.next;
            deleteNode.value = tempNode.value;
            deleteNode.next = tempNode.next;
            tempNode = null;
        } else if (headNode == deleteNode){ // ����ֻ��һ����㣬ɾ��ͷ��㣨Ҳ��β��㣩:O(1)ʱ��
            deleteNode = null;
            headNode = null;
        } else{ // �����ж���ڵ㣬Ҫɾ������β�ڵ�:O(n)ʱ��
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
