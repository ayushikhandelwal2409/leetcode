import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= minStack.get(minStack.size() - 1)) {
            minStack.add(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int topVal = stack.remove(stack.size() - 1);
            if (topVal == minStack.get(minStack.size() - 1)) {
                minStack.remove(minStack.size() - 1);
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.get(stack.size() - 1);
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.get(minStack.size() - 1);
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */