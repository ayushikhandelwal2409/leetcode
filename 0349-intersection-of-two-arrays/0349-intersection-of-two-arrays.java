class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet <Integer> set1=new HashSet<>();
        HashSet <Integer> set2=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }   
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }
        int[] arr=new int[set2.size()];
        int ind=0;       
        for(int n:set2){
            arr[ind]=n;
            ind++;
        }
        return arr;            
    }
}