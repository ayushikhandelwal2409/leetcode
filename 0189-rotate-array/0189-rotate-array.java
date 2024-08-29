class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr=new int[nums.length];
        k = k % nums.length; 
        int j=nums.length-k;
        int n=0;
        if(k<nums.length){
            for(int i=j;i<nums.length;i++){
            arr[n]=nums[i];
            n++;
        }
        int m=n;
        for(int i=0;i<j;i++){
            arr[m]=nums[i];
            m++;
        }
        for (int i = 0; i < arr.length; i++){
            nums[i]=arr[i];
        }
        }
        
    }
}