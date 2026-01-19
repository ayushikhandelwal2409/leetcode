class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='#'){
                if(!st.isEmpty())
                st.pop();
            }
            else
            st.push(ch);
        }
        String a="";
        while(!st.isEmpty()){
            a+=st.pop();
        }
        for(char ch:t.toCharArray()){
            if(ch=='#'){
                if(!st.isEmpty())
                st.pop();
            }
            else
            st.push(ch);
        }
        String b="";
        while(!st.isEmpty()){
            b+=st.pop();
        }
        return a.equals(b);
    }
}