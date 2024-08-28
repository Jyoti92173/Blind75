/*
Problem Statement: Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
Each product is guaranteed to fit in a 32-bit integer.
*/
class ProductOfArrayExceptSelf{
	// Approach 1: Brute Force.....
    public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
			for (int i = 0; i < n; i++) {
			   int product = 1;
				for (int j = 0; j < n; j++) {
				 if (i != j) 
				 product = product * nums[j];
				}
				result[i] = product;
			}
			 return result;
	}
	// Time Complexity: O(n^2)
	// Space Complexity: O(n) 
	
	// Approach 2: Using Array......
    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left = left * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i]* right;
            right = right* nums[i];
        }
        return result;
    }
	public static void main(String[] args){
		ProductOfArrayExceptSelf product=new ProductOfArrayExceptSelf();
		int nums[]={1,2,4,6};
		System.out.println(product.ProductOfArrayExceptSelf(nums));
		System.out.println(product.ProductOfArrayExceptSelf1(nums));
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n)
	
} 