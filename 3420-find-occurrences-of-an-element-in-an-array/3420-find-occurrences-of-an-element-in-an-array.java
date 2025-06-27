class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int c=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                map.put(c,i);
                c++;
            }
        }
        for(int i=0;i<queries.length;i++) 
        {
            if(queries[i] <= map.size())
            {
                queries[i] = map.get(queries[i]);
            }
            else queries[i] = -1;
        }
        return queries;
    }
}