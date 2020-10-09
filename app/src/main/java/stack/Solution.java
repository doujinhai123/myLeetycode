package stack;

import java.util.Stack;

public class Solution {
    Stack<Integer> stackPush = new Stack<Integer>();
    Stack<Integer> stackPop = new Stack<Integer>();

    public void push(int x) {
        stackPush.push(x);
    }

    public int pop() {
        if (!stackPop.isEmpty()) {
            return stackPop.pop();
        } else {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
            return  stackPop.pop();
        }
    }
    public boolean empty() {
        return stackPop.isEmpty()&& stackPush.isEmpty();
    }
    public int peek() {
        return  stackPop.peek();
    }
}
