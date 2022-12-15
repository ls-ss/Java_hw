/* Учитывая корень бинарного дерева, проверьте, является ли он зеркалом самого себя 
  (т.е. симметричным относительно своего центра).
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricSubTree(root.left, root.right);
    }

    public boolean isSymmetricSubTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (   (left != null && right != null) 
            && (left.val == right.val) 
            && isSymmetricSubTree(left.left, right.right) 
            && isSymmetricSubTree(left.right, right.left) ) {
            return true;
        }
        return false;
    }
}
