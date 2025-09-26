class Solution {
    public int secondHighest(String s) {
        TreeSet<Integer> set=new TreeSet<>();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                set.add(ch-'0');
            }
        }
        //System.out.println(set.size());
        if(set.size()>0)set.remove(set.last());
        return set.size()==0?-1:set.last();
    }
}