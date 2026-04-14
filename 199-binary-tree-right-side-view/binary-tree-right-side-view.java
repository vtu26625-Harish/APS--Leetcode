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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        right(root, res, 0);
        return res;
    }
    private void right(TreeNode root, ArrayList<Integer> res, int level){
        if(root == null) return;

        if(level==res.size()) res.add(root.val);

        right(root.right, res, level+1);
        right(root.left, res, level+1);
    }
}