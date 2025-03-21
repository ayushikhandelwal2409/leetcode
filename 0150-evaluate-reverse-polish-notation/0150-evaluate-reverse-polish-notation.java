class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        int n1=0;
        int n2=0;
        for(int i=0;i<tokens.length;i++){
            if(isNumber(tokens[i])){
                st.push(Integer.valueOf(tokens[i]));
            }
            else if(tokens[i].equals("+")){
                n1=st.pop();
                n2=st.pop();
                st.push(n1+n2);
            }
            else if(tokens[i].equals("-")){
                n1=st.pop();
                n2=st.pop();
                st.push(n2-n1);
            }
            else if(tokens[i].equals("*")){
                n1=st.pop();
                n2=st.pop();
                st.push(n1*n2);
            }
            else if(tokens[i].equals("/")){
                n1=st.pop();
                n2=st.pop();
                st.push(n2/n1);
            }
        }
        return st.peek();
    }
    private boolean isNumber(String token) {
        // Check if the token is a valid integer
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}