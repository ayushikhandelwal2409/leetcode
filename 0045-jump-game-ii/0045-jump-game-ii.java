// class Solution {
//     public int jump(int[] nums) {
//         int jumps=0;
//         int l=0;
//         int r=0;
//         while(r<nums.length-1){
//             int farthest=0;
//             for(int i=l;i<=r;i++){
//                 farthest=Math.max(i+nums[i],farthest);
//             }
//             l=r+1;
//             r=farthest;
//             jumps+=1;
//         }
//         return jumps;
//     }
// }

// //method 2


class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int i=0;
        int max_jump=0;
        int endJump=0;
        while(i<nums.length-1){
            max_jump=Math.max(i+nums[i],max_jump);
            if(i==endJump){
                jumps++;
                endJump=max_jump;
            }
            i++;
        }
        return jumps;
    }
}