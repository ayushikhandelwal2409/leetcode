class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] arr=new int[n];
        int depth=0;
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                depth++;
                arr[i]=depth%2;
            }
            else{
                arr[i]=(depth%2==0)?0:1;
                depth--;
            }
        }
        return arr;
    }
}