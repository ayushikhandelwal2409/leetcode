class Solution {
    public int[] nextGreaterElement(int[] a, int[] b) {
        int n=b.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()  && b[st.peek()]<b[i]){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(b[i],-1);
            }
            else{
                map.put(b[i],b[st.peek()]);
            }
            st.push(i);
        }
        int[] ans=new int[a.length];
        for(int i=0;i<a.length;i++){
            ans[i]=map.get(a[i]);
        }
        return ans;
    }
}