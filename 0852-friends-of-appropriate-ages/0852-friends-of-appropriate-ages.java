class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int age : ages)
            count.put(age, count.getOrDefault(age, 0) + 1);
        int n=ages.length;
        int res=0;
        for(int a : count.keySet()){
            for(int b : count.keySet()){
                if(!(b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100))){
                    res+=count.get(a) * (count.get(b) - (a == b ? 1 : 0));
                }
            }
        }
        return res;
    }
}