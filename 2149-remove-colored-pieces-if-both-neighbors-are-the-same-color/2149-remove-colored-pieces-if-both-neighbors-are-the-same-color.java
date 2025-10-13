class Solution {
    public boolean winnerOfGame(String colors) {
        int n=colors.length();
        if(n==1) {
            return false;
        }
        int bMoves=0;
        int aMoves=0;

        for(int i=1;i<n-1;i++){
            if((colors.charAt(i-1)==colors.charAt(i)) && (colors.charAt(i)==colors.charAt(i+1))){
                if (colors.charAt(i) == 'A') aMoves++;
                else bMoves++;
            }
        }
        return aMoves>bMoves;
    }
}