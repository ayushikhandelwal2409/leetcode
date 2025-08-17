class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        for(int i=0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            l.get(u).add(v);
            l.get(v).add(u);
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{1,0});//node,time
        boolean[] vis=new boolean[n+1];
        vis[1]=true;
        Queue<Double> p=new LinkedList<>();
        p.offer(1.0);//probability of root node 
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int node=cur[0];
            int time=cur[1];
            double prob=p.poll();
            double count=0.0;
            if(time>t) break;
            for(int neighbour:l.get(node)){
                if(!vis[neighbour]) count++;
            }
            if(node==target){
                if(time==t || count==0.0) return prob;
                else return 0.0;
            }
            for(int neighbour:l.get(node)){
                if(!vis[neighbour]){
                    q.offer(new int[]{neighbour,time+1});
                    p.offer(prob/count);
                    vis[neighbour]=true;
                }
            }
        }
        return 0.0;
    }
}