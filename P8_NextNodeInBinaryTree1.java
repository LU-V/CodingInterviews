package CodingInterviews;
//结合左程云代码chapter3-problem17（书上第151页）和P8_NextNodeInBinaryTree（网上找的）
public class P8_NextNodeInBinaryTree1 {
    static class Node{
        public Node left;
        public Node right;
        public Node parent;
        int value;
        public Node(int data) {
            this.value = data;
        }
    }
    public static Node getNextNode(Node node){

        if(node!=null){
            if(node.right!=null){
                Node cur = null;
                cur = node.right;
                while (cur.left!=null){
                    cur=cur.left;
                }
                return cur;
            }else{
                while(node.parent!=null&&node!=node.parent.left){
                    node=node.parent;
                }
                return node.parent;
            }
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        P8_NextNodeInBinaryTree1.Node head = new P8_NextNodeInBinaryTree1.Node(6);
        head.parent = null;
        head.left = new P8_NextNodeInBinaryTree1.Node(3);
        head.left.parent = head;
        head.left.left = new P8_NextNodeInBinaryTree1.Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new P8_NextNodeInBinaryTree1.Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new P8_NextNodeInBinaryTree1.Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new P8_NextNodeInBinaryTree1.Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new P8_NextNodeInBinaryTree1.Node(9);
        head.right.parent = head;
        head.right.left = new P8_NextNodeInBinaryTree1.Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new P8_NextNodeInBinaryTree1.Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new P8_NextNodeInBinaryTree1.Node(10);
        head.right.right.parent = head.right;

        P8_NextNodeInBinaryTree1.Node test = head.left.left;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.left;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.right;
        System.out.println(test.value + " parent: " + getNextNode(test).value);
        test = head.right.right; // 10's parent is null
        System.out.println(test.value + " parent: " + getNextNode(test));
    }
}
