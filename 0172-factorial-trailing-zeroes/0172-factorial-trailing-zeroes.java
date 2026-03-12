class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        while(n>=5){
            int k=n/5;
            ans+=k;
            n=k;
        }
        return ans;
    }
}