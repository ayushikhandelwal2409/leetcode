class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        return ways(s,0,dp);
    }
    public int ways(String s,int i,int[] dp){
        if(i==s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if(dp[i]!=0) return dp[i];

        int count = ways(s, i + 1,dp);
        // Take two digits if valid
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                count += ways(s, i + 2,dp);
            }
        }

        return dp[i]=count;
    }
}