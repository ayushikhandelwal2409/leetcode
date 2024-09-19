import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
                arr.add(nums[i]);
        }
        // int l=k%arr.size();
        int in=arr.size()-k;
        return arr.get(in);
    }
}