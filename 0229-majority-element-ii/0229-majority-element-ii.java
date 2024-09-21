import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int k = nums.length / 3;
        int val1 = nums[0], val2 = nums[0];
        int in1 = 1, in2 = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val1) {
                in1++;
            } else if (nums[i] == val2) {
                in2++;
            } else if (in1 == 0) {
                val1 = nums[i];
                in1 = 1;
            } else if (in2 == 0) {
                val2 = nums[i];
                in2 = 1;
            } else {
                in1--;
                in2--;
            }
        }

        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == val1) {
                count1++;
            } else if (num == val2) {
                count2++;
            }
        }

        if (count1 > k) {
            list.add(val1);
        }
        if (count2 > k) {
            list.add(val2);
        }
        return list;
    }
}