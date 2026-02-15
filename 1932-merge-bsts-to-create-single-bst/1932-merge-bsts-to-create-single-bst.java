/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> roots = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();
        
        for (TreeNode root : trees) {
            roots.put(root.val, root);
            if (root.left != null) leaves.add(root.left.val);
            if (root.right != null) leaves.add(root.right.val);
        }
        
        TreeNode mainRoot = null;

        for (TreeNode root : trees) {
            if (!leaves.contains(root.val)) {
                if (mainRoot != null) return null; // in case of multiple roots
                mainRoot = root;
            }
        }
        
        if (mainRoot == null) return null;
        
        roots.remove(mainRoot.val);
        if(!merge(mainRoot, roots, Long.MIN_VALUE, Long.MAX_VALUE)){
            return null;
        }
        if (!roots.isEmpty()) return null; // not all merged
        return mainRoot;
    }
    //validating bst at each merge
    public boolean merge(TreeNode node, Map<Integer, TreeNode> roots, long min, long max){
        if(node==null) return true;
        if(min>=node.val || max<=node.val) return false;

        if(node.left==null && node.right==null  && roots.containsKey(node.val)){
            TreeNode k=roots.remove(node.val);
            node.left=k.left;
            node.right=k.right;
        }
        return (
                merge(node.left,roots,min,node.val) 
                && 
                merge(node.right,roots,node.val,max)
        );
    }
}