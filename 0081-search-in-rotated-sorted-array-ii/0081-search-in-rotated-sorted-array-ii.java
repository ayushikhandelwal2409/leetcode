class Solution {
    public boolean search(int[] nums, int target) {
        int in=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                in=i;
                break;
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=in+1;i<nums.length;i++){
            list.add(nums[i]);
        }
        for(int i=0;i<=in;i++){
            list.add(nums[i]);
        }
        int s=0;
        int e=list.size() - 1;
        System.out.println(list);
        while(s<=e){
            int mid=s+(e-s)/2;
            if(list.get(mid)>target) e=mid-1;
            else if(list.get(mid)==target){
                return true;
            }
            else s=mid+1;
        }
        return false;
    }
}