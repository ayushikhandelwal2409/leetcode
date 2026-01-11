class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return min_operation(word1,word2,0,0,dp);
    }
    public static int min_operation(String s,String t,int i,int j,int[][] dp){
        if (i == s.length()) return t.length() - j; // need to insert remaining chars
        if (j == t.length()) return s.length() - i;// need to delete remaining chars

        if (dp[i][j] != -1) return dp[i][j];

        int ans=0;
        if(s.charAt(i)==t.charAt(j)){
            ans=min_operation(s, t, i+1,j+1,dp);
        }
        else{
            int delete = 1+min_operation(s, t, i +  1, j,dp);
            int replace = 1+min_operation(s, t, i +  1, j + 1,dp);
            int insert = 1+min_operation(s, t, i , j + 1,dp);
            ans = Math.min(delete, Math.min(replace, insert)) ;
        }
        return dp[i][j]=ans;
    }
}