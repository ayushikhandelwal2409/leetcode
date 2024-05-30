class Solution {
    public boolean isPalindrome(int x) {
        int a=x,rev=0,n=0;
        while(a!=0){
          n=a%10;
          rev=n+(rev*10);
          a/=10;  
        }
        if(x==rev&&x>=0){
            return true;}
        else{ 
            return false;}
    }
}