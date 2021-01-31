package stack;

import java.util.Stack;

public class MyStackToQueue {
    Stack<Integer>  pushStack = new Stack<>();
    Stack<Integer>  popStack = new Stack<>();
    public MyStackToQueue() {

    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {

        if(popStack.isEmpty() && pushStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }



}
