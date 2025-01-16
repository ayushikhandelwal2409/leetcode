class Solution {
    static String[] key={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void letterCombo(String s,String ans,List<String> ll ) {
        if(s.length()==0){
            ll.add(ans);
            return;
        }
        char ch=s.charAt(0);
        String getString= key[ch-'0'];
        for (int i = 0; i < getString.length(); i++) {
            letterCombo(s.substring(1), ans+getString.charAt(i),ll);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ll=new ArrayList<>();
        if(digits.length()==0) return ll;
        letterCombo(digits,"",ll);
        return ll;
    }
}