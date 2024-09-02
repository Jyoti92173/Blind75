/*
Problem Statement: You are given an array of length n which was originally sorted in ascending order. It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:
[3,4,5,6,1,2] if it was rotated 4 times.
[1,2,3,4,5,6] if it was rotated 6 times.
Given the rotated sorted array nums and an integer target, return the index of target within nums, or -1 if it is not present.
You may assume all elements in the sorted rotated array nums are unique,
*/

class TargetRotatedArray {
	// Approach 1: Brute Force ..........
    public int search(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
	 public int search1(int[] nums, int target) {
	// Approach 2: Binary Search.........
        int low=0;
        int high=nums.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
	public static void main(String[] args){
		int []nums={3,4,5,6,1,2};
		int target=1;
		TargetRotatedArray targetrotated=new TargetRotatedArray();
		System.out.println(targetrotated.search(nums, target));
		System.out.println(targetrotated.search1(nums, target));
	}
}
