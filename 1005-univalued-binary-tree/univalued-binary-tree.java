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
    public boolean isUnivalTree(TreeNode root) {
        int val=root.val;
        return f(root,val);
    }
 public boolean f(TreeNode node,int val){
    if(node==null){
        return true;
    }
    if(node.val!=val) return false;
    if(!f(node.left,val)) return false;
    if(!f(node.right,val)) return false;
    return true;
 }
}