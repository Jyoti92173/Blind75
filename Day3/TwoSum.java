/*
Problem Statement: Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
Return the answer with the smaller index first.
*/
class TwoSum {
	// Approach 1: Brute Force...
    public int[] twoSum(int[] nums, int target) {
		for (int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i]+nums[j]==target){
						return new int[]{i,j};
				}
			}
		}
			return new int[] {};
	}
	//Time complexity: O(N^2)
	//Space Complexity: O(1)
	
	// Approach 2: Two Pointer...
	 public int[] twoSum1(int[] nums, int target) {
		int n = nums.length;
		int []ans = new int[2];
		int i = 0; 
		int j = i+1;
			while(i<j) {
			   if(nums[i]+nums[j]==target){
				   ans[0] = i;
				   ans[1] = j;
				   break;
			   } else if(j==n-1) {
				   i++;
				   j = i+1;
			   } else {
				   j++;
			   }
			}
		return ans;
	 }
	 // Time Complexity : O(N^2)
	 // Space Complexity: O(1)
	 public int[] twoSum2(int[] nums, int target) {
		   int n = nums.length;
			int []ans = new int[2];
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int i=0; i<n; i++) {
				int result=target-nums[i];
				if(hm.containsKey(result)) {
					ans[0] = hm.get(result);
					ans[1] = i;
					return ans;
				}
				hm.put(nums[i], i);
			}
			return ans;
	 }
	  //Time complexity: O(N)
	  //Space Complexity: O(N)
	 
	 public static void main(String[] args){
		 TwoSum twosum=new TwoSum();
		 int nums[]={3,4,5,6};
		 int target=7;
		 System.out.println(twoSum.TwoSum(nums,target));
		 System.out.println(twoSum.TwoSum1(nums,target));
		 System.out.println(twoSum.TwoSum2(nums,target));
	 }
	
}
