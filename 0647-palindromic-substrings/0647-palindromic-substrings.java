class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++)
            cnt+=palindromic(s,i,j);
        }
        return cnt;
    }
    public static int palindromic(String s,int st,int end){
        while(st<end){
            if(s.charAt(st)!=s.charAt(end)){
                return 0;
            }
            st++;
            end--;
        }
        return 1;
    }

}