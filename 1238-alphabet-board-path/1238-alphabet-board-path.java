class Solution {
    public String alphabetBoardPath(String target) {
        List<String> board = new ArrayList<>();
        board.add("abcde");
        board.add("fghij");
        board.add("klmno");
        board.add("pqrst");
        board.add("uvwxy");
        board.add("z");
        StringBuilder s=new StringBuilder();
        int i=0;
        int j=0;
        for(int k=0;k<target.length();k++){
            char ch=target.charAt(k);
            int n=(ch-'a')/5;
            int m=(ch-'a')%5;
            while (j > m) {
                --j;
                s.append('L');
            }
            // Move up while the current row is below the target row
            while (i > n) {
                --i;
                s.append('U');
            }
            // Move right while the current column is to the left of the target column
            while (j < m) {
                ++j;
                s.append('R');
            }
            // Move down while the current row is above the target row
            while (i < n) {
                ++i;
                s.append('D');
            }
            s.append('!');
        }
        return s.toString();
    }
}