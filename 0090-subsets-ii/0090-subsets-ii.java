class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //List<List<Integer>> ll=new  ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        //List<Integer> temp=new  ArrayList<>();
        Arrays.sort(nums);
        print(nums,set,new ArrayList<>(),0);
        //return ll;
        return new ArrayList<>(set);

    }
    public static void print(int[] nums,HashSet<List<Integer>> set,List<Integer>temp,int start){
        set.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++){
            // if (i > start && nums[i] == nums[i - 1]) {
            //     continue; 
            // }
            temp.add(nums[i]);
            print(nums,set,temp,i+1);

            temp.remove(temp.size()-1);//backtrack
        }
    
    }
}