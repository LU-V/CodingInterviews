package CodingInterviews;

import java.util.ArrayList;

public class P34_PathInTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return arr;
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        int sum = 0;
        pa(root, target, arr, a1, sum);
        return arr;
    }

    public static void pa(TreeNode root, int target, ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> a1, int sum) {
        if (root == null)
            return;
        sum += root.val;

        if (root.left == null && root.right == null) {
            if (sum == target) {
                a1.add(root.val);
                arr.add(new ArrayList<Integer>(a1));
                a1.remove(a1.size() - 1);

            }
            return;

        }

        a1.add(root.val);
        pa(root.left, target, arr, a1, sum);
        pa(root.right, target, arr, a1, sum);
        a1.remove(a1.size() - 1);


    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(10);
        t.left=new TreeNode(5);
        t.right = new TreeNode(12);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(7);

        System.out.println(FindPath(t,22));
    }
}


