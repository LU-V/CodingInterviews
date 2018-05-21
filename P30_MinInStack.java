package CodingInterviews;

import java.util.Stack;

public class P30_MinInStack {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> stack1 = new Stack<>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        int p=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min(){
        int min = stack.peek();
        while(stack.isEmpty()!=true){
            int node =stack.pop();
            if (node <min  ){
                min=node;
            }
            stack1.push(node);
        }
        while (stack1.isEmpty()!=true){
            stack.push(stack1.pop());
        }
        return min;
    }

    public static void main(String[] args) {
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        P30_MinInStack minInStack = new P30_MinInStack();

        System.out.println(minInStack.min());
    }
}
