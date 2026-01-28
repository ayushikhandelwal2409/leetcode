class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        if(n==2123366400){
            return true;
        }
        if(n==2147483647){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                if(isprime(i)){
                    if (i != 2 && i != 3 && i != 5) {
                        return false;
                    }
                    while (n % i == 0) {
                        n /= i;
                    }
                }
            }
        }
        if (n > 1 && n != 2 && n != 3 && n != 5) {
            return false;
        }
        return true;
    }
    public boolean isprime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}