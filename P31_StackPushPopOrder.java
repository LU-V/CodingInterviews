package CodingInterviews;

import java.util.Stack;

public class P31_StackPushPopOrder {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA == null || pushA == null || popA.length == 0 || pushA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int j = 0;
        st.push(pushA[i++]);
        while (j <= popA.length - 1) {
            while (popA[j] != st.peek()) {
                if (i == pushA.length) return false;
                st.push(pushA[i++]);
            }
            j++;
            st.pop();
        }
        return true;
    }

    public static boolean IsPopOrder1(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //���ڱ�ʶ�������е�λ��
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);

            //���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //��ջ
                s.pop();
                //�����������һλ
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {4, 3, 5, 2, 1};
        int c[] = {1, 2, 3, 4, 5};
        System.out.println(IsPopOrder1(a, b));
        System.out.println(IsPopOrder1(a, c));
    }
}