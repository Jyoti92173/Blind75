/* Problem Statement: Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
*/

class DiagonalSum {
    public int diagonalSum1(int[][] mat) {
		// Approach 1 : Brute Force ...
        int sum = 0;
        for( int i =0; i<mat.length; i++){
            for(int j = 0; j <mat.length; j++){
                if(i == j){
                    sum = sum + mat[i][j]; // Primary Diagonal
					     }else if(j == mat.length -1 - i){
                 sum = sum + mat[i][j];  // Secondary Diagonal 
               }
             }
        }
        return sum;
		// Time complexity : O(n^2)
    }
	public int diagonalSum2(int[][]mat){
		// Approach 2 : Optimal Solution.........
		int sum = 0;
		for(int i = 0; i<mat.length; i++){
			sum = sum + mat[i][i];
			 if(i != mat.length - i - 1){
                sum = sum + mat[i][mat.length - i - 1];
            } 
		}
		return sum;
	}
	
	public int diagonalSum3(int[][]mat){
		// Approach 3 : Two Pointer 
		if (mat == null || mat.length == 0){
			return 0;
		  }

		int left = 0;
        int right = mat.length-1;
        int sum = 0;
         for (int i = 0; i<mat.length; i++) {
            if (left != right) {
              sum = sum+mat[i][left]+mat[i][right];
            } else {
                 sum = sum + mat[i][left];
            }
			left++;
			right--;
        }
         return sum;
	}
	public static void main(String [] args){
		int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};
		DiagonalSum  Ds = new DiagonalSum();
		System.out.println(Ds.diagonalSum1(mat));
		System.out.println(Ds.diagonalSum2(mat));
		System.out.println(Ds.diagonalSum3(mat));
	}
 