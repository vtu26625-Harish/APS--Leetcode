class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = root;
                    nodes.add(root.val);
                    root = root.left;
                } else {
                    pre.right = null;
                    root = root.right;
                }
            } else {
                nodes.add(root.val);
                root = root.right;
            }
        }
        return nodes;
    }
}