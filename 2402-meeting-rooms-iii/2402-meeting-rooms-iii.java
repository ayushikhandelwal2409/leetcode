class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] ans=new int[n];
        int j=0;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<long[]> busy=new PriorityQueue<>((a,b)-> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));//endtime,room
        PriorityQueue<Integer> free=new PriorityQueue<>();
        for (int i = 0; i < n; i++) free.offer(i);
        for(int i=0;i<meetings.length;i++){
            int[] curr=meetings[i];
            int start=curr[0];
            int end=curr[1];
            int dur=end-start;
            while (!busy.isEmpty() && busy.peek()[0] <= start) { // make room free and reuse it
                free.offer((int) busy.poll()[1]);
            }
            if(!free.isEmpty()){
                int room=free.poll();
                ans[room]++;
                busy.add(new long[]{end,room});
            }
            else{
                long[] arr= busy.poll();
                busy.offer(new long[]{arr[0]+dur,arr[1]});
                ans[(int)arr[1]]++;
            }
        }
        int idx=0;
        for(int i=1;i<n;i++){
            if(ans[i]>ans[idx]){
                idx=i;
            }
        }
        return idx;
    }
}