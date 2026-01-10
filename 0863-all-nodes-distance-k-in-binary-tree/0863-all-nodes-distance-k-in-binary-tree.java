import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: Build the graph (adjacency list)
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        // Step 2: Perform BFS from the target node to find all nodes at distance K
        List<Integer> result = new ArrayList<>();
        bfs(graph, target, k, result);
        return result;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;
        
        graph.putIfAbsent(node, new ArrayList<>());
        
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    private void bfs(Map<TreeNode, List<TreeNode>> graph, TreeNode target, int k, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        queue.offer(target);
        visited.add(target);
        
        int currentDistance = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            if (currentDistance == k) {
                // We've reached the exact distance K
                for (int i = 0; i < size; i++) {
                    result.add(queue.poll().val);
                }
                return; // We're done
            }
            
            // Otherwise, explore the next level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                for (TreeNode neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
            
            currentDistance++;
        }
    }
}
