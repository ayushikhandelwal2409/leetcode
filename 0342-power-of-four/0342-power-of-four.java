class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        if(n==1) return true;
        int mod=n%4;
        boolean k=(mod==0);
        return isPowerOfFour(n/4)  && k ;
    }
}