class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list=new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n=intervals.length;
        int start=intervals[0][0];
        int end=intervals[0][1];
        int i=1;
        while(i<n){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }
            else{
                list.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
            i++;
        }
        list.add(new int[]{start,end});
        int l=list.size();
        int[][] ans=new int[l][2];
        for(int j=0;j<l;j++){
            ans[j]=list.get(j);
        }
        return ans;
    }
}