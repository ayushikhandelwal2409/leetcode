class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            if(map.containsKey(i)){
                return i;
            }
        }
        return -1;
    }
}