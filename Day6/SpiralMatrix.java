/*
Problem Statement: Given an m x n matrix of integers matrix, return a list of all elements within the matrix in spiral order.
Example 1: Input: matrix = [[1,2],[3,4]]

Output: [1,2,4,3]
*/

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
		// Approach : Boundary Traversal Method......
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
	public static void main(String[] args){
		SpiralMatrix spiral=new SpiralMatrix();
		int matrix[][]={1,2,3,4};
		System.out.println(spiral.spiralOrder()matrix);
	}
}
