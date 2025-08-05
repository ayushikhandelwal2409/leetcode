class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set=new HashSet<>();
        HashSet<String> ans=new HashSet<>();
        int n=s.length();
        for(int i=0;i+9<n;i++){
            String subpart=s.substring(i,i+10);
            if(set.contains(subpart)){
                ans.add(subpart);
            }
            else{
                set.add(subpart);
            }
        }
        return new ArrayList(ans);
    }
}