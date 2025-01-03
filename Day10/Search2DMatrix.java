/* Problem Statement: You are given an m x n 2-D integer array matrix and an integer target.

Each row in matrix is sorted in non-decreasing order.
The first integer of every row is greater than the last integer of the previous row.
Return true if target exists within matrix or false otherwise.

Can you write a solution that runs in O(log(m * n)) time?*/
class Search2DMatrix{
    public boolean searchMatrix1(int[][] matrix, int target) {
        // Linear Search.......
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
	public boolean searchMatrix2(int[][] matrix, int target) {
		// Approach 2: Using Binary Search.......
        int ROWS = matrix.length, COLS = matrix[0].length;
        int l = 0, r = ROWS * COLS - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / COLS, col = m % COLS;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args){
		int matrix[][] = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};
		int target = 10;
		Search2DMatrix search = new Search2DMatrix();
		System.out.println(search.searchMatrix1(matrix,target));
		System.out.println(search.searchMatrix2(matrix,target));
	}
}
