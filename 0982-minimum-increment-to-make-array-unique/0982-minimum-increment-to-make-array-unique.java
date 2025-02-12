class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int c=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                c+=nums[i-1]+1-nums[i];
                nums[i]=nums[i-1]+1;
            }
        }
        return c;
    }
}
// class Solution {
//     public int minIncrementForUnique(int[] nums) {
//         HashSet<Integer> set=new HashSet<>();
//         int c=0;
//         for(int i=0;i<nums.length;i++){
//             while(set.contains(nums[i])){
//                 nums[i]+=1;
//                 c++;
//             }
//             set.add(nums[i]);
//         }
//         return c;
//     }
// }