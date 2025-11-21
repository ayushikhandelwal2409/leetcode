// class Solution {
//     public int intersectionSizeTwo(int[][] intervals) {
//       Arrays.sort(intervals, (a, b)->a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
//         int n=intervals.length;
//         PriorityQueue<Integer> pq=new PriorityQueue<>();
//         int[] prev=intervals[0];
//         pq.add(prev[1]-1);
//         pq.add(prev[1]);
//         for(int i=1;i<n;i++){
//             int[] curr=intervals[i];
//             // if(!pq.isEmpty() && pq.peek()<=curr[0]){ 
//             //     pq.add(curr[1]);
//             //     continue;
//             // }
//             if(prev[1]==curr[0]){ 
//                 pq.add(curr[1]);
//                 continue;
//             }else if(prev[1]>curr[0]){ 
//                 continue;
//             }
//             else{
//                 pq.add(curr[1]-1);
//                 pq.add(curr[1]);
//                 prev=curr;
//             }
            
//         }
//         return pq.size();
//     }
// }

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        // 1. Sort intervals
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );

        int count = 0;

        int a = -1;  // smaller chosen
        int b = -1;  // larger chosen

        for (int[] in : intervals) {
            int start = in[0];
            int end = in[1];

            // Case 1: both inside
            if (a >= start && b >= start) {
                continue;
            }

            // Case 2: only b inside
            if (b >= start) {
                count++;
                a = b;
                b = end;
            } 
            // Case 3: none inside
            else {
                count += 2;
                a = end - 1;
                b = end;
            }
        }

        return count;
    }
}
