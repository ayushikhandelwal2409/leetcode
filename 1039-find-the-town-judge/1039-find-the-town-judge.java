class Solution {
    public int findJudge(int n, int[][] trust) {
        int[][] trustInfo = new int[n + 1][2]; 
        for (int[] t : trust) {
            trustInfo[t[0]][0]++; // person t[0] trusts someone
            trustInfo[t[1]][1]++; // person t[1] is trusted by someone
        }

        for (int i = 1; i <= n; i++) {
            if (trustInfo[i][0] == 0 && trustInfo[i][1] == n - 1) {
                return i; 
            }
        }

        return -1;
    }
}







// class Solution {
//     public int findJudge(int n, int[][] trust) {
//         if(n==1) return 1;
//         int[] arr=new int[n+1];
//         for(int[] l:trust){
//             arr[l[0]]--;
//             arr[l[1]]++;
//         }
//         for (int i = 1; i <= n; i++) {
//             if (arr[i] == n - 1) {
//                 return i; 
//             }
//         }
//         return -1;
//     }
// }