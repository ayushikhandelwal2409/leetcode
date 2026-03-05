class Solution {
    public int minOperations(String s) {
        int cnt1=0;
        boolean one=true;
        for(char ch:s.toCharArray()){
            if(one && ch!='1'){
                cnt1++;
            }
            else if(!one && ch=='1'){
                cnt1++;
            }
            one=!one;

        }
        int cnt0=0;
        boolean zero=true;
        for(char ch:s.toCharArray()){
            if(zero && ch!='0'){
                cnt0++;
            }
            else if(!zero && ch=='0'){
                cnt0++;
            }
            zero=!zero;

        }
        return Math.min(cnt1,cnt0);
    }
}