class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int maxlen = 0;

        for (int num : numSet) {
            int length = 1;
            if (!numSet.contains(num - 1)) {   
                while (numSet.contains(num + length)) {
                    length++;
                }
                maxlen = Math.max(maxlen, length);
            }
        }
        return maxlen;
    }
}