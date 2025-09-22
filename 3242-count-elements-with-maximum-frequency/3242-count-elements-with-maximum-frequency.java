class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
         int maxFrequency = 0;
        for (int frequency : map.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        int ans=0;
        for(int i:map.keySet()){
            if(map.get(i)==maxFrequency) ans+=map.get(i);
        }
        return ans;
    }
}