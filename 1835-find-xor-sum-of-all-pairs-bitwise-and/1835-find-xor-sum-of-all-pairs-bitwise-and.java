class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1=helper(arr1);
        int xor2=helper(arr2);
        return xor1&xor2;
    }
    public static int helper(int[] arr){
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        return xor;
    }
}