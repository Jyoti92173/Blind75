/*
Problem Statement: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
The output should not contain any duplicate triplets. You may return the output and the triplets in any order. 
*/

class ThreeIntegerSum {
//Approach 1: Brute Force......
    public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
		    for (int j = i + 1; j < n - 1; j++) {
		       for (int k = j + 1; k < n; k++) {
		            if (nums[i] + nums[j] + nums[k] == 0) {
		               List<Integer> triplet = new ArrayList<>();
		               triplet.add(nums[i]);
					   triplet.add(nums[j]);
					   triplet.add(nums[k]);
					   triplet.sort(Integer::compareTo);
		             if (!resultList.contains(triplet)) 
		             resultList.add(triplet);
				   }
			    }
		    }
		}
		resultList.addAll(resultSet);		
		return resultList;
    }
	// Time Complexity: O(n^3)
	 public List<List<Integer>> threeSum1(int[] nums) {
		 // Approach 2: Two Pointer......
		  int target=0;
		  Arrays.sort(nums);
		  Set<List<Integer>> s = new HashSet<>();
		  List<List<Integer>> list = new ArrayList<>();
		  for(int i= 0; i<nums.length; i++){
			int j = i+1;
			int k=nums.length-1;
			while(j<k){
				int sum=nums[i]+nums[j]+nums[k];
				if(sum==target){
					s.add(Arrays.asList(nums[i],nums[j],nums[k]));
					j++;
					k--;
				}else if(sum<target){
					j++;
				}else{
					k--;
				}
			}
		  }
		  list.addAll(s);
		  return list;
	 }
	    public static void main(String [] args){
		threeSum ts=new threeSum();
		int nums[] = {-1,0,1,2,-1,-4};
		System.out.println(ts.threeSum(nums));
		System.out.println(ts.threeSum1(nums));
	    }
    }
