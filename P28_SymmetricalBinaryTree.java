package CodingInterviews;

public class P28_SymmetricalBinaryTree {
    static class TreeNode {
        private TreeNode right;
        private TreeNode left;
        int val;

        public TreeNode(int data) {
            this.val = data;
        }

    }

    public static boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right)
                && isSymmetrical(root1.right, root2.left);
    }

    public static void main(String[] args) {
        //�Գ�
        TreeNode a = new TreeNode(8);
        a.left = new TreeNode(6);
        a.right = new TreeNode(6);
        a.left.left = new TreeNode(5);
        a.left.right = new TreeNode(7);
        a.right.left = new TreeNode(9);
        a.right.right = new TreeNode(5);
        System.out.println(isSymmetrical(a, a));
        //�ṹ���Գ�
        TreeNode b = new TreeNode(7);
        b.left = new TreeNode(7);
        b.right = new TreeNode(7);
        b.left.left = new TreeNode(7);
        b.left.right = new TreeNode(7);
        b.right.left = new TreeNode(7);
        System.out.println(isSymmetrical(b, b));
        //ֻ��һ���ڵ�
        TreeNode c = new TreeNode(1);
        System.out.println(isSymmetrical(c,c));
        //��Ϊ��
        TreeNode d = null;
        System.out.println(isSymmetrical(d,d));

        TreeNode e = new TreeNode(8);
        e.left = new TreeNode(6);
        e.right = new TreeNode(3);
        e.left.left = new TreeNode(5);
        e.left.right = new TreeNode(7);
        e.right.left = new TreeNode(7);
        e.right.right = new TreeNode(5);
        System.out.println(isSymmetrical(e, e));
    }
}