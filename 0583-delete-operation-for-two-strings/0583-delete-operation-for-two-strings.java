class Solution {
    public int minDistance(String word1, String word2) {
        int ans = LCS(word1,word2);
        int n = word1.length();
        int m = word2.length();
        return n+m -2*ans; 
    }
    public int LCS(String word1,String word2){
        int[][] t = new int[word1.length()+1][word2.length()+1];

        
        for(int i = 1; i<word1.length()+1; i++){
            for(int j= 1; j<word2.length()+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[word1.length()][word2.length()];
    }
}