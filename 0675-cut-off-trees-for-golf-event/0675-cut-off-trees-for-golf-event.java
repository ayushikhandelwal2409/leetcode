import java.util.*;

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();

        // Collecting all trees and their heights
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }

        // Sorting trees by height
        trees.sort(Comparator.comparingInt(a -> a[2]));

        int totalSteps = 0;
        int startX = 0, startY = 0;

        for (int[] tree : trees) {
            int steps = bfs(forest, startX, startY, tree[0], tree[1]);
            if (steps == -1) {
                return -1; 
            }
            totalSteps += steps;
            startX = tree[0];
            startY = tree[1];
        }
        return totalSteps;
    }

    public int bfs(List<List<Integer>> forest, int x, int y, int targetX, int targetY) {
        int n = forest.size();
        int m = forest.get(0).size();
        int[][] vis = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0}); // row, col, steps
        vis[x][y] = 1; 

        int[] rowarr = {-1, 0, 1, 0};
        int[] colarr = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] k = q.poll();
            int row = k[0];
            int col = k[1];
            int steps = k[2];

            if (row == targetX && col == targetY) {
                forest.get(row).set(col, 1); // Making the cell a non-tree entity by changing it to 1
                return steps;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = rowarr[i] + row;
                int ncol = colarr[i] + col;
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1 && forest.get(nrow).get(ncol) > 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new int[]{nrow, ncol, steps + 1});
                }
            }
        }
        return -1; 
    }
}
