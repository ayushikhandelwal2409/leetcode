class Solution {
    public int compress(char[] chars) {
        ArrayList<Character> l=new ArrayList<>();
        char c=chars[0];
        int ct=1;
        for(int i=1;i<chars.length;i++){
            if(c==chars[i]){
                ct++;
            }
            else{
                l.add(c);
                if(ct>1){
                    String s=String.valueOf(ct);
                    for(int o=0;o<s.length();o++){
                        l.add(s.charAt(o));
                    }
                }
                ct=1;
                c=chars[i];
            }
        }
        l.add(c);
        if(ct>1){
            String s=String.valueOf(ct);
            for(int o=0;o<s.length();o++){
                l.add(s.charAt(o));
            }
        }
        System.out.println(l);
        for(int j=0;j<l.size();j++){
            chars[j]=l.get(j);
        }
        return l.size();
    }
}