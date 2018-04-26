package CodingInterviews;

import java.util.Stack;

public class P9_QueuewithTwoStacks {
    private static Stack<Integer> QueuewithTwoStacksPop=new Stack();
    private static Stack<Integer> QueuewithTwoStacksPush= new Stack();

    public static void  queuewithTwoStacks(){//����ջʵ�ֶ���
        if(QueuewithTwoStacksPush .isEmpty()){
            return;
        }
        while(!QueuewithTwoStacksPush.isEmpty()){
            QueuewithTwoStacksPop.push(QueuewithTwoStacksPush.pop());
        }
    }
    public static void poll(){
        while(!QueuewithTwoStacksPop.isEmpty()){
            System.out.println(QueuewithTwoStacksPop.pop());
        }
    }

    public static void peek(){//�õݹ�ʵ�ֶ��е�peek
        if(QueuewithTwoStacksPop.isEmpty()){
           return;
        }
        int t =QueuewithTwoStacksPop.pop();
        System.out.println(t);
        peek();
        QueuewithTwoStacksPop.push(t);
    }
    public static void add(int i){
        if(QueuewithTwoStacksPop.isEmpty()){//�õݹ�ʵ���˶��е�add����
            return;
        }
        int t =QueuewithTwoStacksPop.pop();
        add(i);
        if(QueuewithTwoStacksPop.isEmpty()){
            QueuewithTwoStacksPop.push(i);
        }
        QueuewithTwoStacksPop.push(t);
        return;
    }

    public static void main(String[] args) {
        QueuewithTwoStacksPush.push(1);
        QueuewithTwoStacksPush.push(2);
        QueuewithTwoStacksPush.push(3);
        QueuewithTwoStacksPush.push(4);
        QueuewithTwoStacksPush.push(5);
        queuewithTwoStacks();
        add(6);//���6�������
        add(7);//���7�������
        peek();
        poll();
    }
}
