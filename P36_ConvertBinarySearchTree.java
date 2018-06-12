package CodingInterviews;

public class P36_ConvertBinarySearchTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if (pRootOfTree==null){
//            return pRootOfTree;
//        }
//        if (pRootOfTree.left!=null){
//            Convert(pRootOfTree.left);
//        }
//        if (pRootOfTree.right==null){
//            pRootOfTree=pRootOfTree.left.right;
//        }
//
//
//
//
//    }

    public static TreeNode Convert(TreeNode root) {

        if (root == null) return null;
        if (root.left == null && root.right == null)
            return root;

        TreeNode left = Convert(root.left);
        TreeNode p = left;
        while (p != null && p.right != null) {//
            p = p.right;
        }
        if (left != null) {//
            p.right = root;
            root.left = p;
        }

        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }

        return left != null ? left : root;
    }

    public static void main(String[] args) {
        TreeNode h = new TreeNode(10);
        h.left = new TreeNode(6);
        h.right = new TreeNode(14);
        h.right.right = new TreeNode(16);
        h.right.left = new TreeNode(12);
        h.left.left = new TreeNode(4);
        h.left.right = new TreeNode(8);

        Convert(h);
    }
}
