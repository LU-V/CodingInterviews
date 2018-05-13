package CodingInterviews;

public class P26_SubstructureInTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return false;
        if (root1 == null && root2 != null) return false;
        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSubTree(root1, root2);
        }
        if (!flag) {
            flag = HasSubtree(root1.left, root2);
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(8);
        a.left = new TreeNode(8);
        a.right = new TreeNode(7);
        a.left.left = new TreeNode(9);
        a.left.right = new TreeNode(2);
        a.left.right.left = new TreeNode(4);
        a.left.right.right = new TreeNode(7);
        TreeNode b = new TreeNode(8);
        b.left = new TreeNode(9);
        b.right = new TreeNode(2);

        System.out.println(HasSubtree(a, b));

    }
}
