class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int[] prev=intervals[0];
        int cnt=0;
        for(int i=1;i<n;i++){
            if(prev[1]>intervals[i][0]){
                cnt++;
            }
            else{
                prev=intervals[i];
            }
        }
        return cnt;
    }
}