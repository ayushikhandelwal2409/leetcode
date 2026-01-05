class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int a=s1.length();
        int b=s2.length();
        int c=s3.length();
        if(a+b!= c) return false;
        Boolean[][] dp=new Boolean[a+1][b+1];
        return interleave(s1,s2,s3,0,0,dp);
    }
    public static boolean interleave(String s1, String s2, String s3,int i,int j,Boolean[][] dp){
        int k=i+j;
        if(i==s1.length() && j==s2.length()){
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        
        boolean a=false;
        if( i< s1.length() && s1.charAt(i)==s3.charAt(k)){
            a=interleave(s1,s2,s3,i+1,j,dp);
        }
        boolean b=false;
        if( j< s2.length() &&  s2.charAt(j)==s3.charAt(k)){
            b=interleave(s1,s2,s3,i,j+1,dp);
        }
        return dp[i][j]=a||b;
    }
}