class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] !=nums[i-1]){
                count++;
                nums[count]=nums[i];
                
            }    
        }     
        return count+1;
    }
}
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         List<Integer> l=new ArrayList<>();
//         for(int i=0;i<nums.length;i++){
//             if(!l.contains(nums[i])){
//                 l.add(nums[i]);
//             }
//         }
//         int i=0;
//         for( i=0;i<l.size();i++){
//             nums[i]=l.get(i);
//         }
//         return l.size();
//     }
// }