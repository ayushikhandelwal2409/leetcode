class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        Arrays.sort(candidates);
        infinite(candidates,target,l,0,ans);
        return ans;
    }
    public static void infinite(int[] coin,int amount,List<Integer> l,int idx,List<List<Integer>> ans){
        if(amount==0){
            ans.add(new ArrayList<>(l));
            return;
        }
        for (int i = idx; i < coin.length; i++) {
            if (i > idx && coin[i] == coin[i - 1]) {
                continue;
            }
            if(amount>=coin[i]) {
                l.add(coin[i]);
                infinite(coin, amount - coin[i],l,i+1, ans);
                l.remove(l.size()-1);
            }
        }
    }
}