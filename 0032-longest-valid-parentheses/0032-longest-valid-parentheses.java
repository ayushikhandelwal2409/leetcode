class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        int max = 0;
        Stack<Integer> st = new Stack<>();
        int lastInvalid = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (st.isEmpty()) {
                    lastInvalid = i;
                } else {
                    st.pop();
                    if (st.isEmpty()) {
                        max = Math.max(max, i - lastInvalid);
                    } else {
                        max = Math.max(max, i - st.peek());
                    }
                }
            }
        }
        return max;
    }
}