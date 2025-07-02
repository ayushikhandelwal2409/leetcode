class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2) return n;
        int a=1;
        int b=2;
        int c=0;
        for(int i=3;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
        // return check(n,0);
    }
    // public int check(int tar,int sum){
    //     if (sum == tar) return 1;
    //     if (sum > tar) return 0;
    //     return check(tar, sum + 1) + check(tar, sum + 2);
    // }
}