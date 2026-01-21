class Solution {
    public int minimizeXor(int num1, int num2) {
        int cnt=0;
        while(num2>0){
            if((num2 & 1)==1){
                cnt++;
            }
            num2=num2>>1;
        }
        int x = 0;
        // Matching bits with num1
        for (int i = 31; i >= 0 && cnt > 0; i--) {
            if (((num1 >> i) & 1) == 1) {
                x |= (1 << i);
                cnt--;
            }
        }
        // Fill remaining bits from LSB
        for (int i = 0; i <= 31 && cnt > 0; i++) {
            if (((x >> i) & 1) == 0) {
                x |= (1 << i);
                cnt--;
            }
        }

        return x;
    }
    
}