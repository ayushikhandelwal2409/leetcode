class Solution {
    static class Pair {
        char c;
        int count;
        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek().c==ch){
                st.peek().count++;
                if( st.peek().count==k){
                    st.pop();
                }
            }
            else{
                st.push(new Pair(ch, 1));
            }
        }
        for (Pair p : st) {
            sb.append(String.valueOf(p.c).repeat(p.count));
        }

        return sb.toString();
    }
}