/*
Problem Statement:You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.*/

class BinarySearch {
	// Approach 1: Linear Search...............
	public int searchLinear(int nums, int target){
		int n = nums.length;
		int i=0; 
		while(i<n){
			if(nums[i]== target){
				return i;
			}
			i++;
		}
		return -1;
	}
	// Appraoch 2: Two Pointer Approach.........
    public int searchTwoPointer(int[] nums, int target) {
        int start = 0;
        int end=nums.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] ==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
    
        return -1;
    }
	public static void main(String[] args){
		int[] nums = {-1, 0, 2, 4, 6, 8}; 
		int target =4;
		BinarySearch bs=new BinarySearch();
		int res1 = bs.searchLinear(nums, target);
		int res2 = bs.searchTwoPointer(nums, target);
		System.out.println("Linear Search Result: " + res1);
        System.out.println("Binary Search Result: " + res2);
	}
}

