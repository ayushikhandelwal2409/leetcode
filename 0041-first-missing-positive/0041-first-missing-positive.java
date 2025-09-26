class Solution {
    public int firstMissingPositive(int[] nums) {
        //method 1

        // int n=nums.length;
        // int[] check=new int[n+1];
        // for(int i:nums){
        //     if(i<=n && i>0){
        //         check[i]=1;
        //     }
        // }
        // for(int j=1;j<=n;j++){
        //     if(check[j]!=1) return j;
        // }
        // // If nums contains all elements 1 to n
        // // the smallest missing positive number is n + 1
        // return n+1;

        //method 2
        int n=nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[i] != nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)return i+1;
        }
        return n+1;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}