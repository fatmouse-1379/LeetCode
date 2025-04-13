package hot100.tree;

/**
 *105. 从前序与中序遍历序列构造二叉树
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = new TreeNode(1);
        return node;
    }
}
