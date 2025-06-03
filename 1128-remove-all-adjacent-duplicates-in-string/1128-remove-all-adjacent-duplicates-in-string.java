class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && ch==st.peek()){
                st.pop();
            }
            else{
                st.push(ch);
            }    
        }
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}