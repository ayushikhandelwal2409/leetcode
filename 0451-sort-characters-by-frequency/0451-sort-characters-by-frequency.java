class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char i:s.toCharArray()){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Pair<Integer,Character>> pq=new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for(char ch:map.keySet()){
            pq.add(new Pair<>(map.get(ch),ch));
        }
        while(!pq.isEmpty()){
            Pair<Integer,Character> k=pq.poll();
            for(int i=0;i<k.getKey();i++){
                sb.append(k.getValue());
            }
        }
        return sb.toString();
    }
}