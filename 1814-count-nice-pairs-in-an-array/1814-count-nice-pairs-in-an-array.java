class Solution {
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        int[] diff=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=nums[i]-rev(nums[i]);
        }
        int ans=0;
        Map<Integer, Integer> map = new HashMap();
        int mod=(int)1e9+7;
        for(int num:diff){
            ans=(ans+map.getOrDefault(num,0)) %mod;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;

    }
    public static int rev(int x){
        StringBuilder sb=new StringBuilder(String.valueOf(x));
        String s=sb.reverse().toString();
        // int k=0;
        // for(int i=0;i<s.length();i++){
        //     int ch=s.charAt(i)-'0';
        //     k+=ch*10;
        // }
        return Integer.valueOf(s);

    }
}
//original:42 11 1 97
//reverse :24 11 1 79
//nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
//so we get that, x - rev(x) == y - rev(y)