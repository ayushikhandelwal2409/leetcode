class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int h=heights[st.pop()];
                int r=i;
                if(st.isEmpty()){
                    ans=Math.max(h*r,ans);
                }
                else{
                    int l=st.peek();
                    int area=h*(r-l-1);
                    ans=Math.max(ans,area);
                }
            }
            st.push(i);
        }
        int r=heights.length;
        while(!st.isEmpty()){
            int h=heights[st.pop()];
            if(st.isEmpty()){
                ans=Math.max(h*r,ans);
            }
            else{
                int l=st.peek();
                int area=h*(r-l-1);
                ans=Math.max(ans,area);
            }
        }
        return ans;
    }
}