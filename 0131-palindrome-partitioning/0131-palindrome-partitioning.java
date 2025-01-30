class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> s1=new  ArrayList<>();
        List<String > s2=new ArrayList<>();
        cut(s,s1,s2);
        return s1;
    }
    public static void cut(String s, List<List<String>> ans,List<String> s2){
        if(s.length()==0){
            ans.add(new ArrayList<>(s2));
            return;
        }
        for(int i=0;i<s.length();i++){
            String k=s.substring(0,i+1);
            if(IsPalindrome(k)){
                s2.add(k);
                cut(s.substring(i+1),ans,s2);
                s2.remove(s2.size()-1);
            }
        }
    }
    public static boolean IsPalindrome(String s){
        int i=0;
        int j =s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}