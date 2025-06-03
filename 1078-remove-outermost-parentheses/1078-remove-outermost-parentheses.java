class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(char c:s.toCharArray()){
            if (c == '(') {
                // If stack is not empty, this '(' is not an outer parenthesis
                if (!st.isEmpty()) {
                    ans.append(c);
                }
                st.push(c);
            } else {
                // Pop the matching '('
                st.pop();
                // If stack is not empty after popping, this ')' is not an outer parenthesis
                if (!st.isEmpty()) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }
}