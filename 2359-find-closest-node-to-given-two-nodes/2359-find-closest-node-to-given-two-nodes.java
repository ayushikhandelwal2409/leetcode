class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[] dist1=new int[n];
        int[] dist2=new int[n];

        Arrays.fill(dist1,-1);
        Arrays.fill(dist2,-1);

        int dis=0;
        int curnode=node1;
        while(curnode!=-1 && dist1[curnode]==-1){
            dist1[curnode]=dis++;
            curnode=edges[curnode];
        }

        dis=0;
        curnode=node2;
        while(curnode!=-1 && dist2[curnode]==-1){
            dist2[curnode]=dis++;
            curnode=edges[curnode];
        }
        //find min max
        int node =-1;
        int minOFmax=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dist1[i]!=-1 && dist2[i]!=-1){
                int max= Math.max(dist1[i],dist2[i]);
                if(minOFmax >max){
                    minOFmax=max;
                    node=i;
                }
            }
        }

        return node;
    }
}