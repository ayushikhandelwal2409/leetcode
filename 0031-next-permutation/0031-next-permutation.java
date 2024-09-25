class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int p=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                p=i;
                break;
            }
        }
        for(int i=n-1;i>p && p!=-1;i--){
            if (nums[i]>nums[p]){
                int temp=nums[p];
                nums[p]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        int i=p+1;
        int j=n-1;
        while(i<j){
            int te=nums[i];
            nums[i]=nums[j];
            nums[j]=te;
            i++;
            j--;

        }
    }
}