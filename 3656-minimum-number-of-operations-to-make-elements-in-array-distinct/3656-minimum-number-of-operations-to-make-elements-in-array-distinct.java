class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int[] map=new int[101];
        for(int i: nums){
            map[i]++;
        }
        int operations =0;
        int idx=0;
        while(!unique(map)){
            int c=3;
            while( idx <n && c-->0){
                map[nums[idx]]--;
                idx++;
            }
            operations++;
        }  
        return operations;
    }
    public static boolean unique(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>1) return false;
        }
        return true;
    }
}