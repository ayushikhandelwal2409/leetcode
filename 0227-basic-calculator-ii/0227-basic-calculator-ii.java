class Solution {
    public int calculate(String s) {
        int ans=0;
        int cur=0;
        int len = s.length();
        char operation = '+';
        Stack<Integer> st=new Stack<>();
        for(int i = 0; i < len; i++){
             char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                cur=(cur*10)+(ch-'0');
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i==len-1) {
                if (operation == '-') {
                    st.push(-cur);
                }
                else if (operation == '+') {
                    st.push(cur);
                }
                else if (operation == '*') {
                    st.push(st.pop() * cur);
                }
                else if (operation == '/') {
                    st.push(st.pop() / cur);
                }
                operation = ch;
                cur = 0;
            }
        }
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }
}