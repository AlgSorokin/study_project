package binaryTree;

import java.util.Stack;

public class TreeInorderTraversal {
    /*
                   20
               /        \
               7        35
           /      \     /     \
           4       9   31     40
            \          /      / \
             6        28     38 52
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20,
                new TreeNode(7, new TreeNode(4, null, new TreeNode(6)), new TreeNode(9)),
                new TreeNode(35, new TreeNode(31, new TreeNode(28), null), new TreeNode(40, new TreeNode(38), new TreeNode(52))));
        inorderTraversalIterativeWithStack(root);
        inorderTraversalRecursive(root);
    }

    private static void inorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            inorderTraversalRecursive(node.left);
            System.out.println(node.value);
            inorderTraversalRecursive(node.right);
        }
        //4, 6, 7, 9, 20, 28, 31, 35, 38, 40, 52
    }
    private static void inorderTraversalIterativeWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.value);
            curr = curr.right;
        }
        //4, 6, 7, 9, 20, 28, 31, 35, 38, 40, 52
    }
}
