class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int[] check=new int[n+1];
        for(int i:nums){
            if(i<=n && i>0){
                check[i]=1;
            }
        }
        for(int j=1;j<=n;j++){
            if(check[j]!=1) return j;
        }
        return n+1;
    }
}