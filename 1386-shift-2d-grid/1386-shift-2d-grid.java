class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        List<List<Integer>> ll=new ArrayList<>();
        for(int i=0;i<n;i++){
            ll.add(new ArrayList<>());
        }
        k%=(n*m);
        int total_ele=n*m;
        int start =total_ele-k;
        int x=0;
        for(int i=start;i<total_ele+start ;i++){
            int r=(i/m)%n;
            int c=i%m;
            ll.get(x/m).add(grid[r][c]);
            x++;
        }
        return ll;
    }
}