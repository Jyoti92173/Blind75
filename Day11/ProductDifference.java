/* Problem Statement : The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

Return the maximum such product difference
*/

class ProductDifference {
    public static int maxProductDifference1(int[] nums) {
      int max1=Integer.MIN_VALUE;
      int max2=Integer.MIN_VALUE;
      int min1=Integer.MAX_VALUE;
      int min2=Integer.MAX_VALUE;

      for(int n : nums){
          if(n>max1){
              max2=max1;
              max1=n;
          }
          else if(n>max2){
              max2=n;
          }

          if(n<min1){
              min2=min1;
              min1=n;
          }
          else if(n<min2){
              min2=n;
          }
      }
	  return (max1*max2)-(min1*min2);
    }
	public static int maxProductDifference2(int nums){
		Arrays.sort(nums);
		int n = nums.length;
		int maxDiff = nums[n-1]*nums[n-2] - nums[0]*nums[1];
		return maxDiff;
	}
	public static void main(String [] args){
		int []nums = {5,6,2,7,4};
		System.out.println(maxProductDifference1(nums));
		System.out.println(maxProductDifference2(nums));
	}
}