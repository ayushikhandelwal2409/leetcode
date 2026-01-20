class MinStack {
    Stack<Integer> minstack;
    Stack<Integer> st;
    public MinStack() {
        minstack=new Stack<>();
        st=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if( minstack.isEmpty()|| minstack.peek()>=val){
            minstack.push(val);
        }
       // if() minstack.push(val);
    }
    
    public void pop() {
        if(!st.isEmpty()){
            if(!minstack.isEmpty() && st.peek().equals(minstack.peek())){
                minstack.pop();
            }
           st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        //if(!minstack.isEmpty()){
            return minstack.peek();
        // }
        // return st.peek();
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