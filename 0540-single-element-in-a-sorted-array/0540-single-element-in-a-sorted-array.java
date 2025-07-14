class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end){   // left half   single value   right half
            int mid=start+(end-start)/2;
            if(mid%2==1){
                mid--;
            }
            if(nums[mid]==nums[mid+1]){  // single value is available in righthalf and not in lefthalf
                start=mid+2;
            }
            else{      // value is available in left half
                end=mid;
            }
        }
        return nums[start];
    }
}