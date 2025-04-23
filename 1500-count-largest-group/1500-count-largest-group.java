class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=n;i++){
            int sum=getSum(i);
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        int max=0;
        for(int i:map.values()){
            max=Math.max(i,max);
        }
        int count=0;
        for(int i:map.values()){
            if(i==max){
                count++;
            }
        }
        return count;
    }
    public static int getSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}