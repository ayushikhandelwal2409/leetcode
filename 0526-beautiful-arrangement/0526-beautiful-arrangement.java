class Solution {
    int count=0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }

    private void backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % pos == 0 || pos % num == 0)) {
                visited[num] = true;
                backtrack(n, pos + 1, visited);
                visited[num] = false;
            }
        }
    }
}