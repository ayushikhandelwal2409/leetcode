class Solution {
    public long calculateScore(String s) {
        Stack<Integer>[] arr=new Stack[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new Stack<>();
        }
        long ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
           char mirror=(char)('z'-(ch-'a')); 
            if(arr[mirror-'a'].isEmpty()){
                arr[ch-'a'].push(i);
            }
            else{
                int prev_idx=arr[mirror-'a'].pop();
                ans+=(i-prev_idx);
            }
        }
        return ans;
    }
}