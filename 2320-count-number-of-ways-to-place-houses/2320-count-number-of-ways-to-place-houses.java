class Solution {
    int mod=1_000_000_007;
    public int countHousePlacements(int n) {
        long[] dp=new long[n+2];  //n+2 to safely access idx+2
        Arrays.fill(dp,-1);
        long oneside= houses(0,n,dp);
        long ans=(oneside*oneside)%mod;
        return (int)(ans);
    }
    public  long houses(int idx,int n,long[] dp){
        if(idx>=n) return 1;

        if(dp[idx]!=-1) return dp[idx];

        long inc= houses(idx+2,n,dp);
        long exc=houses(idx+1,n,dp);

        return dp[idx]=(inc+exc)%mod;
    }
}

//houses(0)
// ├── exclude → houses(1)
// │   ├── exclude → houses(2)
// │   │   ├── exclude → houses(3) = 1
// │   │   └── include → houses(4) = 1
// │   │   dp[2] = 2
// │   └── include → houses(3) = 1
// │       dp[1] = 3
// └── include → houses(2)
//     (already computed → 2)

//n==3 ---> (3+2)=>5*5=>  25 ans