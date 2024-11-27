class Solution {
    public int romanToInt(String s) {
        int sum=0;
        int prev=0;
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            int cur=0;
            if(c=='M'){
                cur=1000;
                if(cur>=prev) sum+=cur;
                else sum-=cur;
                prev=cur;
            }
            else if(c=='D'){
                cur=500;
                if(cur>=prev) sum+=cur;
                else sum-=cur;
                prev =cur;
            }
            else if(c=='C'){
                cur=100;
                if(cur>=prev) sum+=cur;
                else sum-=cur;
                prev =cur;
            }
            else if(c=='L'){
                cur=50;
                if(cur>=prev) sum+=cur;
                else sum-=cur;
                prev =cur;
            }
            else if(c=='X'){
                cur=10;
                if(cur>=prev) sum+=cur;
                else sum-=cur;
                prev =cur;
            }
            else if(c=='V'){
                cur=5;
                if(cur>=prev) sum+=cur;
                else sum-=cur;
                prev =cur;
            }
            else if(c=='I'){
                cur=1;
                if(cur>=prev) sum+=cur;
                else sum-=cur;
                prev =cur;
            }
        }
        return sum;
    }
}