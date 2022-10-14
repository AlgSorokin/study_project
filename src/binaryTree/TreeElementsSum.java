package binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TreeElementsSum {

    /* sum = 270
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
//        System.out.println(sumRecursive(root));
//        System.out.println(sumDeep(root));
        System.out.println(sumWide(root));

    }

    private static int sumRecursive(TreeNode root) {
        int sum = root.value;
        System.out.println(root.value);

        if (root.left != null) {
            sum += sumRecursive(root.left);
        }

        if (root.right != null) {
            sum += sumRecursive(root.right);
        }
        return sum;
    }

    private static int sumDeep(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);
            sum += node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sum;
    }

    private static int sumWide(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.value);
            sum += node.value;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return sum;
    }

}
