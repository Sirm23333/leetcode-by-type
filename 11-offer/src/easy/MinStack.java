package easy;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || x <= min.peek())
            min.push(x);
    }

    public void pop() {
        if(stack.pop().equals(min.peek()))
            min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
