class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder ss = new StringBuilder();
        int sum=0;
        for(int i=shifts.length-1;i>=0;i--){
            sum+=shifts[i]%26;
            char ch=(char)((s.charAt(i)-'a'+sum)%26 + 'a');
            ss.append(ch);
        }
        ss.reverse();
        return ss.toString();
    }
}