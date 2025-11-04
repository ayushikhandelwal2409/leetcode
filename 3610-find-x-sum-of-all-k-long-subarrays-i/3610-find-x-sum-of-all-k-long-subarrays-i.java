class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
         int n=nums.length;
        int[] ans=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
            ArrayList<int[]> l=new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                l.add(new int[]{entry.getValue(),entry.getKey()});
            }
            l.sort((a,b)->a[0]!=b[0]?b[0]-a[0]:b[1]-a[1]);
            int cnt=0;
            for(int j=0;j<x && j<l.size();j++){
                cnt+=l.get(j)[0]*l.get(j)[1];
            }
            ans[i]=cnt;
        }
        return ans;
    }
}