class MyStack {

    private Queue<Integer> q1;
    public MyStack(){
        q1=new LinkedList<>();
    }
    public void push(int val){
        q1.offer(val);
        for (int i = 0; i < q1.size()-1; i++) {
            q1.offer(q1.poll());
        }
    }
    public int pop(){
        return q1.poll();
    }
    public int top(){
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */