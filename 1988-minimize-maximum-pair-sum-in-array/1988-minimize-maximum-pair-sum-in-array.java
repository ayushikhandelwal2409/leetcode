class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int j=n-1;
        int maxSum = 0;
        while(i<j){
            int sum=nums[i]+nums[j];
            maxSum=Math.max(maxSum,sum);
            i++;
            j--;
        }
        return maxSum;
    }
}

// 2 3 4 4 5 6
// 2,6=8
// 3,5=8
// 4,4=8
