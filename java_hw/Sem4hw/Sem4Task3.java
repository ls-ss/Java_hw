/* 101. Симметричное дерево.
	Учитывая корень бинарного дерева, проверьте, является ли он зеркалом самого себя 
	(т.е. симметричным относительно своего центра).
*/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Deque<TreeNode> roots = new ArrayDeque<>();
        roots.addFirst(root.left);
        roots.addLast(root.right);
        while (roots.size() % 2 == 0 && roots.size() > 0) {
            TreeNode left = roots.pollFirst();
            TreeNode right = roots.pollLast();
            if ((left.val != right.val) || (left.left == null && right.right != null) ||
                    (left.right == null && right.left != null) || (left.left != null && right.right == null) ||
                    (left.right != null && right.left == null)) {
                return false;
            }
            if (left.left != null && right.right != null) {
                roots.addFirst(left.left);
                roots.addLast(right.right);
            }
            if (left.right != null && right.left != null) {
                roots.addFirst(left.right);
                roots.addLast(right.left);
            }
        }
        return roots.size() == 0;
    }
} 