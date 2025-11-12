class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int count_of_one=0;
        int gcd=0;
        for(int x:nums){
            if(x==1){
                count_of_one++;
            }
            gcd=GCD(gcd,x);
        }

        if(count_of_one>0){
            return n-count_of_one;
        }

        if(gcd>1){
            return -1;
        }
        int minLen = n;
        for (int i = 0; i < n; i++) {
            int currentGcd = 0;
            for (int j = i; j < n; j++) {
                currentGcd = GCD(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen + n - 2;
    }
    public static int GCD(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}