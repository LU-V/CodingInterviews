package CodingInterviews;

public class P27_MirrorOfBinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int data) {
            this.val = data;
        }
    }
    public static void Mirror(TreeNode root){
        if (root ==null){
            return;
        }
        if (root.left==null&&root.right==null){
            return;
        }
        TreeNode t = root.left;
        root.left=root.right;
        root.right=t;

        if (root.left!=null){
            Mirror(root.left);
        }
        if (root.right!=null){
            Mirror(root.right);
        }
    }


    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        a.left = new TreeNode(6);
        a.right = new TreeNode(10);
        a.left.left = new TreeNode(5);
        a.left.right = new TreeNode(7);
        a.right.left = new TreeNode(9);
        a.right.right = new TreeNode(11);
        Mirror(a);

        System.out.println("over");

    }
}
