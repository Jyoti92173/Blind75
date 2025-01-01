
/* Problem Statement: Given the root of a binary tree, return its depth.
The depth of a binary tree is defined as the number of nodes along the longest path from the root node down to the farthest leaf node.*/

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }
 

class BinaryTreeMaxDepth{
    public int maxDepthUsingRecursion(TreeNode root) {
		// Approach 1: Using Recursion......
        if(root == null){
            return 0;
        }
        int left = maxDepthUsingRecursion(root.left);
        int right = maxDepthUsingRecursion(root.right);
        int maxDep = Math.max(left,right);
        return maxDep +1;
        
    }
	public int maxDepthUsingBFS(TreeNode root){
		// Approach 2: Using BFS.......
	 Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return level;
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
		Integer []root = {1,2,3,null,null,4};
		BinaryTreeMaxDepth bt = new BinaryTree();
		TreeNode root = bt.createTree(root, 0);
		System.out.println("Max Depth Using Recursion: " + bt.maxDepthUsingRecursion(root));
        System.out.println("Max Depth Using BFS: " + bt.maxDepthUsingBFS(root));
		
}
