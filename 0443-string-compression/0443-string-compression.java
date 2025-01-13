class Solution {
    public int compress(char[] chars) {
        ArrayList<Character> l=new ArrayList<>();
        char c=chars[0];
        int ct=1;
        int ind=0;
        for(int i=1;i<chars.length;i++){
            if(c==chars[i]){
                ct++;
            }
            else{
                chars[ind++]=c;
                l.add(c);
                if(ct>1){
                    String s=String.valueOf(ct);
                    for(int o=0;o<s.length();o++){
                        l.add(s.charAt(o));
                        chars[ind++]=s.charAt(o);
                    }
                }
                ct=1;
                c=chars[i];
            }
        }
        l.add(c);
        chars[ind++]=c;
        if(ct>1){
            String s=String.valueOf(ct);
            for(int o=0;o<s.length();o++){
                l.add(s.charAt(o));
                chars[ind++]=s.charAt(o);
            }
        }
        return ind;
    }
}