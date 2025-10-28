class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int num_of_nonzeroes=0;
        for(int i:nums){
            if(i>0) num_of_nonzeroes++;
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                if(isvalid(nums,num_of_nonzeroes,i,-1)) cnt++;
                if(isvalid(nums,num_of_nonzeroes,i,1)) cnt++;
            }
        }
        return cnt;
    }
    public static  boolean isvalid(int[] nums,int nonZeros,int idx,int dir){
        int n=nums.length;
        int curr=idx;
        int[] temp=nums.clone();
        while(nonZeros>0 && curr>=0 && curr<n){
            if(temp[curr]>0){
                temp[curr]--;
                dir*=-1;
                if(temp[curr]==0) nonZeros--;
            }
            curr+=dir;
        }
        return nonZeros==0;
    }
}