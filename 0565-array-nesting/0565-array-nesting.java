class Solution {
    public int arrayNesting(int[] nums) {
        //ArrayList<Integer> l=new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                HashSet<Integer> l = new HashSet<>();
                int currentIndex = i;
                while(!visited[currentIndex]){
                    visited[currentIndex] = true; 
                    currentIndex=nums[currentIndex];
                    l.add(nums[currentIndex]);
                }
                maxLength=Math.max(maxLength,l.size());
            }
        }   
        return maxLength;
    }
}