class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0; a < nums.length-3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            for (int b = a + 1; b < nums.length-2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;
                int left = b + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long currentSum =(long) nums[a] + nums[b] + nums[left] + nums[right];

                    if (currentSum == target) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}