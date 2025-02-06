class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll=new  ArrayList<>();
        List<Integer> temp=new  ArrayList<>();
        print(nums,ll,temp,0);
        return ll;

    }
    public static void print(int[] nums,List<List<Integer>>ll,List<Integer>temp,int start){
        ll.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            print(nums,ll,temp,i+1);

            temp.remove(temp.size()-1);//backtrack
        }
    }
}