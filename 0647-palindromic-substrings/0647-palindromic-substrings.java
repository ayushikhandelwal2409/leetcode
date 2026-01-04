class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        boolean[][] dp=new boolean[n][n];
        //1 substring
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            cnt++;
        }
        //2  length substring
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                cnt++;
            }
        }
        //for length >=3 substring
        for(int len=2;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

//bruteforce
// class Solution {
//     public int countSubstrings(String s) {
//         int n=s.length();
//         int cnt=0;
//         for(int i=0;i<n;i++){
//             for(int j=i;j<n;j++)
//             cnt+=palindromic(s,i,j);
//         }
//         return cnt;
//     }
//     public static int palindromic(String s,int st,int end){
//         while(st<end){
//             if(s.charAt(st)!=s.charAt(end)){
//                 return 0;
//             }
//             st++;
//             end--;
//         }
//         return 1;
//     }

// }