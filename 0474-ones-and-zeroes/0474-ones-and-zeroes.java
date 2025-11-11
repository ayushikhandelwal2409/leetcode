class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;
        int[][][] dp=new int[l][m+1][n+1];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return subset(l-1,strs,dp,m,n);
    }
    public int subset(int idx,String[] strs,int[][][] dp,int m ,int n){
        if(idx<0){
            return 0;
        }
        if(dp[idx][m][n]!=-1){
            return dp[idx][m][n];
        }
        int pick = 0;
        int[] count = new int[2]; 

        if (isValid(strs[idx], m, n, count)) {
            pick = 1 + subset(idx-1,strs, dp,m - count[0], n - count[1]);
        }
        int notPick = subset(idx-1,strs,dp, m, n);
        return dp[idx][m][n]=Math.max(pick,notPick);

    }
    private boolean isValid(String s, int m, int n, int[] count) {
        int zero = 0, one = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') one++;
            else zero++;
        }

        count[0] = zero;
        count[1] = one;

        return zero <= m && one <= n;
    }

}