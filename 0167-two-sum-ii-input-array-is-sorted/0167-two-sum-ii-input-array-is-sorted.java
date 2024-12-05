class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=numbers.length-1;
        int right=0;
        int[] arr=new int[2];
        while(right<=left){
            if(numbers[right]+numbers[left]==target){
                arr[0]=right+1;
                arr[1]=left+1;
                return arr;
            }
            else if(numbers[right]+numbers[left]>target){
                left--;
            }
            else{
                right++;
            }
        }
        return arr;
    }
}