/*
Problem Statement: Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.*/
class MaxPositiveAndNegative {
    public int maximumCount(int[] nums) {
		// Approach : Binary Search.............
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int negCount = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] < 0){
                negCount = mid+1;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        int posCount = n-negCount - countZeroes(nums);
        return Math.max(posCount,negCount);
       
    }
     public int countZeroes(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            }
        }
        return count;
     }
	 public static void main(String[] args){
		 int arr[]= {-2,-1,-1,1,2,3};
		 int arr1[]={-3,-2,-1,0,0,1,2};
		 MaxPositiveAndNegative pn = new MaxPositiveAndNegative();
		 System.out.println(pn.maximumCount(arr));
		  System.out.println(pn.maximumCount(arr1));
		 
	 }
}