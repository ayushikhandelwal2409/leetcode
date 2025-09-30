class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            char ch=p.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int start=0;
        HashMap<Character,Integer> s_freq=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            s_freq.put(ch,s_freq.getOrDefault(ch,0)+1);
            if( i-start+1>m ){
                s_freq.put(s.charAt(start),s_freq.get(s.charAt(start))-1);
                if(s_freq.get(s.charAt(start))==0){
                    s_freq.remove(s.charAt(start));
                }
                start++;
            }

            if(s_freq.equals(map)){
                ans.add(start);
            }
        }
        return ans;
    }
}