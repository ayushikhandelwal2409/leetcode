class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        possible_strings(ans,"",s,0);
        return ans;
    }
    public void possible_strings(List<String> ans,String str,String s,int idx){
        if(idx==s.length()){
            ans.add(str);
            return ;
        }
        char  ch=s.charAt(idx);
        if(Character.isDigit(ch)){
            possible_strings(ans,str+ch,s,idx+1);
        }
        else{
            possible_strings(ans,str+Character.toUpperCase(ch),s,idx+1);
            possible_strings(ans,str + Character.toLowerCase(ch),s,idx+1);
        }
    }
}