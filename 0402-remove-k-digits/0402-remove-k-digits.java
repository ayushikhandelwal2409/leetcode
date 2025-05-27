class Solution {
    private int max;
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if(k==0){
            return num;
        }
        if(k>=num.length()){
            return "0";
        }
        for(char ch:num.toCharArray()){
            while(!st.isEmpty() && k>0 &&  st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        res.reverse();
        String result=res.toString();
        String ans=result.replaceFirst("^0+(?!$)", "");
        return ans;
    }
}