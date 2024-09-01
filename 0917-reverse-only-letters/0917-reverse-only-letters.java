class Solution {
    public String reverseOnlyLetters(String s) {
        int n=s.length();
        String s2="";
        for(int m =n-1;m>=0;m--){
            if((s.charAt(m)>='a' && s.charAt(m)<='z') || (s.charAt(m)>='A' && s.charAt(m)<='Z') )
                s2+=s.charAt(m);
        }
        char[] arr=new char[n];
        for(int i =0;i<n;i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') )
                arr[i]=' ';
            else
                arr[i]=s.charAt(i);
        }
        String s1="";
        int k=0;
        for(int j =0;j<arr.length;j++){
            if(arr[j]==' '){
                s1+=s2.charAt(k);
                k++;}
            else{
                s1+=arr[j];
            }
        }
        return s1;
    }
}