class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<asteroids.length;i++){
            if(asteroids[i] > 0) {
                st.push(i);
            }
            else{
                while(!st.isEmpty() && asteroids[st.peek()]>0 && asteroids[st.peek()]<-asteroids[i]){
                    st.pop();
                }
                 if (st.isEmpty() ||asteroids[st.peek()] < 0)  {
                    st.push(i);
                }
                if (asteroids[st.peek()]== -asteroids[i]) {
                    st.pop();
                }
            }
        }
        int[] ans =new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            ans[i]=asteroids[st.pop()];
            i--;
        }
        return ans;
    }
}