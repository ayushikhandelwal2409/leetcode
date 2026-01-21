class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1=helper(nums1);
        int xor2=helper(nums2);
        int n=nums1.length;
        int m=nums2.length;
        if(n%2==0 && m%2==0){
            return 0;
        }
        else if(n%2==1 && m%2==0){ //3,4 =>even ka xor is answer
            return xor2;
        }
         else if(n%2==0 && m%2==1){//4,3 =>even ka xor is answer
            return xor1;
        }
        else{
            return xor1^xor2;
        }
    }
    public static int helper(int[] arr){
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        return xor;
    }
}