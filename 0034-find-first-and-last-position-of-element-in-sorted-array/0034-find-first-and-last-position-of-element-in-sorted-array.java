class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] arr=new int[2];
        arr[0]=chl(nums,target);
        arr[1]=chh(nums,target);
        return arr;
    }
    public static int chl(int[]nums,int target){
        int l=0;
        int h=nums.length-1;
        int fpos=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                fpos=mid;
                h =mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return fpos;
    }
    public static int chh(int[]nums,int target){
        int l=0;
        int h=nums.length-1;
        int lpos=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                lpos=mid;
                l=mid+1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return lpos;
    }
}