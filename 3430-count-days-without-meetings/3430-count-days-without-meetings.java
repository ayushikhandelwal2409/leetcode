class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Merge meetings
        int mergedStart = meetings[0][0];
        int mergedEnd = meetings[0][1];
        int occupiedDays = 0;

        for (int i = 1; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            if (start <= mergedEnd) { // Overlapping meetings
                mergedEnd = Math.max(mergedEnd, end);
            } else { // Non-overlapping meeting
                occupiedDays += (mergedEnd - mergedStart + 1);
                mergedStart = start;
                mergedEnd = end;
            }
        }
        occupiedDays += (mergedEnd - mergedStart + 1);
        return days - occupiedDays;


        // boolean[] vis=new boolean[days+1];
        // for(int i=0;i<meetings.length;i++){
        //     int a=meetings[i][0];
        //     int b=meetings[i][1];
        //     while(b>=a){
        //         vis[b]=true;
        //         b--;
        //     }
        // }
        // int count=0;
        // for(int i=1;i<vis.length;i++){
        //     if(vis[i]==false)
        //         count++;
        // }
        // return count;
    }
}