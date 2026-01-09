class Solution {
    int[] prefix;
    int sum;
    Random rand=new Random();
    public Solution(int[] w) {
        sum=0;
        prefix=new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefix[i] = sum;  
        }
    }
    
    public int pickIndex() {
        int tar=rand.nextInt(sum)+1;//[1,sum] ==> generate uniform randoms from range
        int s=0;
        int e=prefix.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(prefix[mid]<tar){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return s;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */