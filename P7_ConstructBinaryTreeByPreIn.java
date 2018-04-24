package CodingInterviews;

import java.util.HashMap;

//给定前中序，构造二叉树
public class P7_ConstructBinaryTreeByPreIn {
    static class Node {
        public Node left;
        public Node right;
        public int value;

        public Node(int data) {
            this.value = data;
        }

    }

    public static Node preIntotree(int pre[], int in[]) {
        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private static Node preIn(int[] pre, int pi, int pj, int[] in, int ni, int nj,
                              HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }
        Node head = new Node(pre[pi]);
        int index = map.get(pre[pi]);
        head.left = preIn(pre, pi + 1, pi + index - ni, in, ni, index - 1, map);
        head.right = preIn(pre, pi + index - ni + 1, pj, in, index + 1, nj, map);
        return head;
    }

    public static Node inPosToTree(int[] in, int pos[]) {
        if (in == null || pos == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return inPos(pos, 0, pos.length - 1, in, 0, in.length - 1, map);
    }

    public static Node inPos(int pos[], int si, int sj, int[] in, int ni, int nj, HashMap<Integer, Integer> map) {
        if (si > sj) {
            return null;
        }
        Node head = new Node(pos[sj]);
        int index = map.get(pos[sj]);
        head.left = inPos(pos, si, si + index - ni - 1, in, ni, index - 1, map);
        head.right = inPos(pos, si + index - ni, sj - 1, in, index + 1, nj, map);
        return head;
    }

    public static Node prePosToTree(int[] pre, int[] pos) {
        if (pre == null || pos == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < pos.length; i++) {
            map.put(pos[i], i);
        }
        return prepos(pre, 0, pre.length - 1, pos, 0, pos.length - 1, map);

    }

    private static Node prepos(int[] pre, int pi, int pj, int[] pos, int si, int sj, HashMap<Integer, Integer> map) {
        Node head = new Node(pos[sj--]);
        if (pi == pj) {
            return head;
        }
        int index = map.get(pre[++pi]);//不可以写成pi++  也不能和上面的sj-- 交换位置  index
        head.left = prepos(pre, pi, pi + index - si, pos, si, index, map);
        head.right = prepos(pre, pi + index - si + 1, pj, pos, index + 1, sj, map);

        return head;
    }


    //下面的三个函数   是打印树的函数
    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 8, 9, 3, 6, 7};
        int[] in = {4, 2, 8, 5, 9, 1, 6, 3, 7};
        int[] pos = {4, 8, 9, 5, 2, 6, 7, 3, 1};
        printTree(preIntotree(pre, in));
        printTree(inPosToTree(in, pos));
        printTree(prePosToTree(pre, pos));

    }
}
