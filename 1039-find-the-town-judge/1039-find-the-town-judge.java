class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1) return 1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] arr:trust){
            map.put(arr[1],map.getOrDefault(arr[1],0)+1);
            map.put(arr[0],map.getOrDefault(arr[0],0)-1);
        }
        for(int i:map.keySet()){
            if(map.get(i)==n-1) return i;
        }
        return -1;
    }
}