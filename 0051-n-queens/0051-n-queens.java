class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        queen_placement(n,0,new ArrayList<>(),list);
        return list;
    }
    private  void queen_placement(int tq, int qpsf,List<String> ans,List<List<String>> list){
        if(qpsf==tq){
            list.add(new ArrayList<>(ans));
            return;
        }
        for (int col = 0; col < tq; col++) {
            if (isSafe(ans, qpsf, col, tq)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tq; i++) {
                    if (i == col) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
                queen_placement( tq, qpsf + 1,ans,list);
                ans.remove(ans.size() - 1); // backtrack
            }
        }
    }
    private boolean isSafe(List<String> board, int row, int col, int n) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // Check the upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // Check the upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}