class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string can be segmented
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // Check if the substring s[j...i-1] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid segmentation
                }
            }
        }
        return dp[s.length()]; 
    }
}