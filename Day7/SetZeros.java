/*
Problem Statement: Given an m x n matrix of integers matrix, if an element is 0, set its entire row and column to 0's.
*/

class SetZeros {
    public void setZeroes(int[][] matrix) {
		// Approach: Two-Pass Algorithm..
        if (matrix == null || matrix.length == 0)
         return;

        int m = matrix.length;  //row   
        int n = matrix[0].length;   //column
        boolean firstRowZero = false;
        boolean firstColZero = false; 

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; 
                    matrix[0][j] = 0; 
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
	
	 public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args){
	   int[][] matrix = {
            {0, 1},
            {1, 0}
        };
	    SetZeros set = new SetZeros();
        set.setZeroes(matrix);
        set.printMatrix(matrix);
	}
	
}

    
