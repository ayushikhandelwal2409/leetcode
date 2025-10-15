class Solution {
    private int[][] dp;
    public int minCut(String s) {
        dp = new int[s.length()][s.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(s, 0, s.length()-1);
    }
    public int solve(String str, int i, int j){
        //Base Cases
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(isPalindrome(str, i, j)){
            dp[i][j]=0;
            return 0;
        }
    
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j;k++){
            if(isPalindrome(str, i, k)){
                int partitions = 1+solve(str, k+1, j);
                min = Math.min(min, partitions);                
            }
            
            
        }
        
        dp[i][j]=min;
        return dp[i][j];
    }
    public boolean isPalindrome(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}