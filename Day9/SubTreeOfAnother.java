/*Problem Statement: Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.*/

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class SubTreeOfAnother{ 
    public boolean isIdentical (TreeNode root, TreeNode subRoot){
        if(root== null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    } 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
	 public TreeNode createTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = createTree(arr, 2 * index + 1);
        root.right = createTree(arr, 2 * index + 2);
        return root;
    }

	public static void main(String []args){
		SubTreeOfAnother subtree = new SubTreeOfAnother();

        Integer[] root = {1, 2, 3, 4, 5};
        Integer[] subRoot = {2, 4, 5};

        TreeNode root = subtree.createTree(root, 0);
        TreeNode subRoot = subtree.createTree(subRoot, 0);

        System.out.println("Is SubTree of Another Tree: " + subtree.isSubtree(root, subRoot));
	}
}
