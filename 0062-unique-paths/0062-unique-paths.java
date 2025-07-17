class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int j=0;j<n;j++) dp[0][j]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

//brute force 
// class Solution {
//     public int uniquePaths(int m, int n) {
//         return recurrsion(0,0,m,n);
//     }
//     public int recurrsion(int i, int j,int m,int n){
//      
//         if(i == m-1 && j == n-1){
//             return 1;
//         }
//         if(i>=m ||j>=n){
//             return 0;
//         }      
//         
//         int down = recurrsion(i+1, j ,m, n);
//         int right = recurrsion(i, j+1  ,m ,n);
//
//         return down + right;
//     }
// }