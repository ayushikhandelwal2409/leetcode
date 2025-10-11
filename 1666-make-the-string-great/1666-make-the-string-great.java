class Solution {
    public String makeGood(String s) {
        StringBuilder  sb=new StringBuilder ();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && Math.abs(s.charAt(i) - st.peek())==32){
                st.pop();
            }
            else
            st.push(s.charAt(i));
        }
         while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}

