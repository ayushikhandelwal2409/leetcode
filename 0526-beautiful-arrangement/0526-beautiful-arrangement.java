class Solution {
    int count=0;
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i+1;
        permute(nums, 0);
        return count;
    }
    public void permute(int[] nums, int idx) {
        if (idx == nums.length ) {
            count++;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            if (nums[idx] % (idx + 1) == 0 || (idx + 1) % nums[idx] == 0) permute(nums,idx+ 1);
            swap(nums, i, idx);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}