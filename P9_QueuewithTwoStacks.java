package CodingInterviews;

import java.util.Stack;

public class P9_QueuewithTwoStacks {
    private static Stack<Integer> QueuewithTwoStacksPop=new Stack();
    private static Stack<Integer> QueuewithTwoStacksPush= new Stack();

    public static void  queuewithTwoStacks(){//两个栈实现队列
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

    public static void peek(){//用递归实现队列的peek
        if(QueuewithTwoStacksPop.isEmpty()){
           return;
        }
        int t =QueuewithTwoStacksPop.pop();
        System.out.println(t);
        peek();
        QueuewithTwoStacksPop.push(t);
    }
    public static void add(int i){
        if(QueuewithTwoStacksPop.isEmpty()){//用递归实现了队列的add方法
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
        add(6);//添加6进入队列
        add(7);//添加7进入队列
        peek();
        poll();
    }
}
