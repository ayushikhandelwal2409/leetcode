class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> ind=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==key) ind.add(i);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int[] vis=new int[nums.length];
        for(int index:ind){
            for(int i=0;i<nums.length;i++){
                if(Math.abs(index-i)<=k && vis[i]==0){
                    vis[i]=1;
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}