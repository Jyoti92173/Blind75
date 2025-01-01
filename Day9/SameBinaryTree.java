
/* Problem Statement: Given the roots of two binary trees p and q, return true if the trees are equivalent, otherwise return false.
Two binary trees are considered equivalent if they share the exact same structure and the nodes have the same values.*/
import java.util.LinkedList;
import java.util.Queue;

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
class SameBinaryTree{
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
		// Approach 1: Using Recursion....
         if(p == null && q == null){
            return true;
         }
         if(p == null || q == null){
            return false;
         }
         if(p.val != q.val){
            return false;
         }
         return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
	 public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
		Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode nodeP = queue1.poll();
            TreeNode nodeQ = queue2.poll();

            if (nodeP == null && nodeQ == null) continue;
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val)
                 return false;

            queue1.add(nodeP.left);
            queue1.add(nodeP.right);
            queue2.add(nodeQ.left);
            queue2.add(nodeQ.right);
        }

        return true;
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
	
	 public static void main(String [] args){
		 Integer []p = {4,7};
		Integer[] q = {4,null,7};
		SameBinaryTree sbt = new SameBinaryTree();
        TreeNode rootP = sbt.createTree(p, 0);
        TreeNode rootQ = sbt.createTree(q, 0);
		System.out.println("Both Trees are Same (Recursive): " + sbt.isSameTreeRecursive(rootP, rootQ));
		System.out.println("Both Trees are Same (BFS): " + sbt.isSameTreeBFS(rootP, rootQ));
		 
		 
	 
	 }
	
}