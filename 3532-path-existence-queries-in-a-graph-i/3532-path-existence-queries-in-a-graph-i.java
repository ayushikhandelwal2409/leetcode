class Solution {
    static class UnionFind{
        int[] parent;
        int[] rank;
        UnionFind(int v){
            parent=new int[v+1];
            rank=new int[v+1];
            for (int i = 0; i <=v; i++) {
                parent[i]=i;
            }
        }

        public int find(int node) {
            if(parent[node]==node){
                return node;
            }
            int n=find(parent[node]);
            parent[node]=n;   // path compression
            return n;
        }
        public boolean union(int u,int v){
            int parent_u=find(u);
            int parent_v=find(v);
            if(parent_v==parent_u){
                return false;    // it means there root nodes are same and on connecting them  it will make cycle so we will not do union
            }
            if(rank[parent_u]> rank[parent_v]){
                parent[parent_v]=parent_u;
            }
            else if(rank[parent_u]<rank[parent_v]){
                parent[parent_u]=parent_v;
            }
            else{
                parent[parent_v]=parent_u;
                rank[parent_u]++;
            }
            return true;
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        UnionFind uf=new UnionFind(n);
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;

        Arrays.sort(idx,(a,b)->nums[a]-nums[b]);

        for(int i=1;i<n;i++){
            if(nums[idx[i]] - nums[idx[i-1]] <= maxDiff){
                uf.union(idx[i], idx[i-1]);
            }
        }
        boolean[] ans = new boolean[queries.length];
        int i=0;
        for(int[] q:queries){
            if(uf.find(q[0])==uf.find(q[1])){
                ans[i]=true;
            }
            i++;
        }
        return ans;
    }
}