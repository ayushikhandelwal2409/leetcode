class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
        per(nums,new ArrayList<>(),list);
        return list;
    }
    public static void per(int[] nums,List<Integer> ans,List<List<Integer>> list){
        if(nums.length==ans.size()){
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(ans.contains(nums[i])) continue;
            ans.add(nums[i]);
            per(nums,ans,list);
            ans.remove(ans.size()-1);
        }
    }
}