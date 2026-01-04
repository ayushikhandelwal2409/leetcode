class Solution {
    int mod = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k==1){
            return Kadanes(arr);
        }
        int n=arr.length;
        long sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+arr[i])%mod;
        }
        int newarr[] = new int[n*2];
        for(int i=0;i<n*2;i++){
            newarr[i] = arr[i%n];
        }
        if(sum<=0){
            return  Kadanes(newarr);
        }
        return (Kadanes(newarr) +(int) (((k-2)*sum)%mod)) %mod;
    }
    public int Kadanes(int arr[]){
        long ans=0;
        long sum=0;
        for(int i : arr){
            sum+=i;
            ans = Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }      
        }
        return (int)ans%mod;
    }
}
//formula => when totalSum >0 = maxsuffix(arr) +( (k - 2) * totalSum ) + maxprefix(arr)