/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;

        TreeNode dummy = new TreeNode(-1);
        dummy.left = root;
        root = dummy;

        TreeNode pre = null;
        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                } else {
                    TreeNode node = pre;
                    reverse(root.left, pre);
                    while (node != root.left) {
                        out.add(node.val);
                        node = node.right;
                    }
                    out.add(node.val); // include root.left
                    reverse(pre, root.left);
                    pre.right = null;
                    root = root.right;
                }
            } else {
                root = root.right;
            }
        }
        return out;
    }

    // Helper method to reverse the right pointers between 'from' and 'to'
    private void reverse(TreeNode from, TreeNode to) {
        if (from == to) return;
        TreeNode x = from, y = from.right, z;
        while (true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x == to) break;
        }
    }
}