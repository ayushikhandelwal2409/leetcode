class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        // int[] arr=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i= 0;i<n;i++){
            sum+=nums[i];
            int r=sum%k;
            if (r<0){
                r+=k;
            }
            count+=map.getOrDefault(r,0);
            map.put(r,map.getOrDefault(r,0) + 1);
        }
        // int s=0;
        // int e=0;
        // while(s<=e && e<n){
        //     if((arr[s])%k==0){
        //         count++;
        //     }
        //     else{
        //         s++;
        //     }
        //     e++;
        // }
        //System.out.println(Arrays.toString(arr));
        return count;
    }
}