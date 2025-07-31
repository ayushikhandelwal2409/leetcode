class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        int tar=n-1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0,ans,path,tar,graph);
        return ans;
    }
    public static void dfs(int src,List<List<Integer>> ans , List<Integer> path,int tar,int[][] graph){
        if(src==tar){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int neighbour:graph[src]){
            path.add(neighbour);
            dfs(neighbour,ans,path,tar,graph);
            path.remove(path.size()-1);
        }
    }
}






























//         Queue<Integer> q=new LinkedList<>();
//         q.add(0);
//         int[] vis=new int[n];
//         List<Integer> k = new ArrayList<>();
//         k.add(0);
//         while(!q.isEmpty()){
//             int node=q.poll();
//             if(node==target){
//                 ans.add(new ArrayList(k));
//                 k=new ArrayList<>();
//             }
//             for(int neighbour:graph[node]){
//                 if(vis[neighbour]==0){
//                     vis[neighbour]=1;
//                     q.offer(neighbour);
//                     k.add(neighbour);  
//                 }
//             }
//         }
//         return ans;
//     }
// }