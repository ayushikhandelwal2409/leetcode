class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int value=1;
        int top = 0 ,left = 0 ,right = n-1, bottom = n-1;
        while(top<=bottom && left <= right){
            for(int i=left;i<=right;i++){
                ans[top][i] = value++;
            }
            top++;
             for(int i=top;i<=bottom;i++){
                 ans[i][right] =value++;
            }
            right--;
            if(top <= bottom){
                for(int i=right;i>=left;i--){
                ans[bottom][i] =value++;
            }
            bottom--;
            }
            if(left <= right){
                for(int i=bottom;i>=top;i--){
                ans[i][left] =value++;
            }
            left++;
            }
        }
        return ans;
    }
}