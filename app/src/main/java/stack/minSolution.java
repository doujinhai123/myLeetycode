package stack;

import java.util.Stack;
class MinStack {

    Stack<Integer> stackA = new Stack<>();
    Stack<Integer> stackB = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int node) {
        stackA.push(node);
        if(stackB.isEmpty()) {
            stackB.push(node);
        }else {
            int peek = stackB.peek();
            if(peek >= node) {
                stackB.push(node);
            } else {
                stackB.push(peek);
            }
        }
    }

    public void pop() {
        if(!stackA.isEmpty()) {
            stackA.pop();
        }

        if(!stackB.isEmpty()) {
            stackB.pop();
        }

    }

    public int top() {
        if(!stackA.isEmpty()) {
            return stackA.peek();
        } else {
            return -1;
        }
    }

    public int getMin() {
        if(!stackB.isEmpty()) {
            return stackB.peek();
        }else {
            return -1;
        }
    }
}
