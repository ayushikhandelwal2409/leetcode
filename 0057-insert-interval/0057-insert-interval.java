class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> l=new ArrayList<>();
        int i = 0;
        //add non-overlapping intervals before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            l.add(intervals[i]);
            i++;
        }
        //Merging overlapping intervals
        while (i< intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        l.add(newInterval);
        //Add non-overlapping intervals after newInterval
        while (i < intervals.length) {
            l.add(intervals[i]);
            i++;
        }
        int[][] ans=new int[l.size()][2];
        int m=0;
        for(int[] k:l){
            ans[m]=k;
            m++;
        }
        return ans;
    }
}