class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int n=queries.length;
        int[] ans=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        int c=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                map.put(c,i);
                c++;
            }
        }
        int j=0;
        for(int i:queries){
            if(map.containsKey(i)){
                ans[j]=map.get(i);
            }
            else{
                ans[j]=-1;
            }
            j++;
        }
        return ans;
    }
}