package com.iqiyi.paopao.myleetycode.stack;

import java.util.Stack;

public class Solution {
    Stack<Integer> stackPush = new Stack<Integer>();
    Stack<Integer> stackPop = new Stack<Integer>();

    public void push(int node) {
        stackPush.push(node);
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
}