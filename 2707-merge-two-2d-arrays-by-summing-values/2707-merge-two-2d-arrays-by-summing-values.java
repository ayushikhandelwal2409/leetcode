class Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> keyToSum = new TreeMap<>();
        for (int[] nums : nums1) {
            keyToSum.put(nums[0], nums[1]);
        }
        for (int[] nums : nums2) {
            keyToSum.put(nums[0], keyToSum.getOrDefault(nums[0], 0) + nums[1]);
        }
        int[][] mergedArray = new int[keyToSum.size()][2];
        int k=0;
        for (Map.Entry<Integer, Integer> entry : keyToSum.entrySet()) {
            mergedArray[k]=(new int[] { entry.getKey(), entry.getValue() });
            k++;
        }

        return mergedArray;
    }
}