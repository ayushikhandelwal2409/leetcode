// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n=nums.length;
//         int[] arr=new int[n];
//         int p1=1;
//         int p2=1;
//         for (int i=0;i<1;i++){
//             for (int j=i+1;j<n;j++){
//                 p2*=nums[j];
//             }
//             for(int j=0;j<i;j++){
//                 p1*=nums[j];
//             }
//         arr[0]=p1*p2;
//         }
//         for (int i=1;i<n;i++){
//             p1*=nums[i-1];
//             if(nums[i]==0){
//                 arr[i]=p1*p2;
//             }else{
//                 p2/=nums[i];
//                 arr[i]=p1*p2;
//             }
//         }
//         return arr;
//     }
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        // Calculate the running product from the left
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] * nums[i - 1];
        }

        // Calculate the running product from the right and multiply with the left product
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return arr;
    }
}