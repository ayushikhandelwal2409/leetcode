class Solution {
    public int smallestRepunitDivByK(int k) {
         int rem = 0;
        for (int len = 1; len <= k; len++) {
            rem = (rem * 10 + 1) % k;
            if (rem == 0) return len;
        }
        return -1;



    //    int[] arr={1,11,111,1111,11111,111111,1111111,11111111,111111111,1111111111};
    //    for(int i=0;i<arr.length;i++){
    //     if(arr[i]%k==0) return i+1;
    //    } 
    //    return -1;
    }
}