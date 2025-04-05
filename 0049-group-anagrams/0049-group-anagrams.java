class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        ArrayList<List<String>> l=new ArrayList<>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(s);
        }
        return new ArrayList<>(map.values());
    }
}