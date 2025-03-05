class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for (String ch : operations){
            if(ch.equals("D")){
                if (!st.isEmpty())
                st.push(st.peek()*2);
            }
            else if(ch.equals("C")){
                if (!st.isEmpty())
                st.pop();
            }
            else if(ch.equals("+")){
                if (st.size() >= 2) {
                    int a=st.pop();
                    int b=st.pop();
                    st.push(b);
                    st.push(a);
                    st.push(a+b);
                }
            }
            else{
                st.push(Integer.valueOf(ch));
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}