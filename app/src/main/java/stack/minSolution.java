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
        if (stackB.isEmpty()|| stackB.peek() >= node) {
            stackB.push(node);
        }

    }

    public void pop() {

        if(stackA.pop().equals(stackB.peek())) {
            stackB.pop();
        }

    }

    public int top() {
        return stackA.peek();
    }

    public int getMin() {
        return stackB.peek();
    }
}
