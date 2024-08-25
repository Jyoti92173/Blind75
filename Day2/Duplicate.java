/*
Problem Statement:  Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
*/

class Duplicate {
	//Approach 1: Brute Force
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
	//Approach 2: HashSet
	public boolean hasDuplicate1(int[] nums) {
		Set<Integer> set=new HashSet<>();
		for(int i=0; i<nums.length; i++){
		   if(set.contains(nums[i]){
			  return true;
		   }
		   set.add(nums[i]);
		}
		return false;
	}
	public static void main(String[] args){
		Duplicate duplicate = new Duplicate();
		int nums[]= {1,2,3,4};
		System.out.println(duplicate.hasDuplicate(nums));
		System.out.println(duplicate.hasDuplicate1(nums));
		
	}
	
}
