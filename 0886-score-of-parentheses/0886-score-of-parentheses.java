class Solution {
    public int scoreOfParentheses(String s) {
        int count=0;
        Stack<Integer> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(count);
                count=0;
            }
            else{
                count=st.pop()+Math.max(2 * count, 1);
            }
        }
        return count ;
    }
}