class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // int ans=left;
        // for(int i=left+1;i<=right;i++){
        //     ans=ans&i;
        // }
        // return ans;
        int cnt=0;
        while(left<right){
            left=left>>1;
            right=right>>1;
            cnt++;
        }
        return left<<cnt;
    }
}