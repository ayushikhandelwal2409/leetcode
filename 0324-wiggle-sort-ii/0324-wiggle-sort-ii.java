class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = (n - 1) / 2; // Middle for smaller half
        int right = n - 1;      // End for larger half

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left--];  
            } else {
                nums[i] = sorted[right--]; 
            }
        }
    }
}