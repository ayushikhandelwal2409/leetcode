class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> l = new HashMap<>();
        for(int[] edge:edges){
            l.put(edge[0], l.getOrDefault(edge[0], 0) + 1);
            l.put(edge[1], l.getOrDefault(edge[1], 0) + 1);
        }
        for(int node:l.keySet()){
            if(l.get(node)==edges.length){
                return node;
            }
        }
        return -1;
    }
}