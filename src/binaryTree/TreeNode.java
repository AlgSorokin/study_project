package binaryTree;

public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;


    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode(int value) {
        this.value = value;
    }
}
