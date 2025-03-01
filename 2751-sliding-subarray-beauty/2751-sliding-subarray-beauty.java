class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int p=0;
        Map<Integer,Integer> hm = new TreeMap<>();
        int l=0;
        int r=0;
        while(r<n){
            if(nums[r]<0) hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            if(r-l+1>k){
                if(nums[l]<0){
                    hm.put(nums[l],hm.get(nums[l])-1);
                    if(hm.get(nums[l])==0)hm.remove(nums[l]);
                }
                l++;
            }
            if(r-l+1==k){
                int count =0;
                boolean flag= false;
                for(Map.Entry<Integer,Integer> it:hm.entrySet()){
                    count+=it.getValue();
                    if(count>=x){
                        res[p]=it.getKey();
                        p++;
                        flag=true;
                        break;
                    }
                }
                if(!flag)res[p++]=0;
            }
            r++;
        }
        return res;
    }
}