/*Problem Statement: Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.*/


class MajorityElement{
	public static int majorityElement(int[] nums){
		// Approach 1: Brute Force with Sorting and Nested Loops.
		Arrays.sort(nums);
		int n = nums.length;
		for(int i=0; i<n; i++){
		int count = 1;
			for(int j = i+1; j<n; j++){
				if(nums[i] == nums[j]){
					count++;
				}
			}
			if(count>n/2){
			return nums[i];
			}
		}
		return -1;
	}
	public static int majority2(int[] nums){
		// Approach 2: Using HashMap
		 Map<Integer,Integer> map = new HashMap<>();
    
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > nums.length/2){
               return key;
            }
        }
        return -1;

	}
	public static void main(String[] args){
		int [] nums = {3,2,3};
		System.out.println(majorityElement(nums));
		System.out.println(majorityElement2(nums));
	}
}

 