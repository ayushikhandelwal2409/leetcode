class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int sum=0;
        ArrayList<ArrayList<Integer>> ll=new ArrayList<>();
        subset(nums,ll,new ArrayList<>(),0);
        for(int i=0;i<ll.size();i++){
            int xor=0;
            for(int num:ll.get(i)){
                xor^=num;
            }
            sum+=xor;
        }
        return sum;

    }
    public static void subset(int[] nums,ArrayList<ArrayList<Integer>> ll,ArrayList<Integer> ans,int idx){
        if(ans.size()!=0) {
            ll.add(new ArrayList<>(ans));
        }
        for(int i=idx;i<nums.length;i++){
            ans.add(nums[i]);
            subset(nums,ll,ans,i+1);
            ans.remove(ans.size()-1);
        }
    }
}