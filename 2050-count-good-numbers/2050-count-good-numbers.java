class Solution {
    long mod=1000000007;
    public int countGoodNumbers(long n) {
        return (int)( ( (pow(5,(n+1)/2)) * (pow(4,n/2)) ) % mod );
    }
    public long pow(int x,long y){
        long mul=x;
        long ret=1;
        while(y>0){
            if(y%2==1)            
            {
                ret = (mul*ret)%mod;
            }
            mul = (mul*mul)%mod;
            y/=2;
        }
        return ret;
    }
}