/*
Problem Statement: Given an array of integers nums, return the length of the longest consecutive sequence of elements.
A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
You must write an algorithm that runs in O(n) time.
*/
class LongestConsecutiveSequence{
	// Approach 1: Brute Force....
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        if(n<2){
            return n;
        }
        int count=1,t=1;
        for(int i=1; i<n; i++){
            if(nums[i]==nums[i-1])
            continue;
            if(nums[i]==nums[i-1]+1){
              count=Math.max(count,++t);
            }else{
                t=1;
            }
        }
        return count;
    }
	public int longestConsecutive1(int[] nums) {
		// Approach 2: HashMap.......
		HashMap<Integer, Boolean> hm = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			hm.put(nums[i],true);
		}
		for(int val : nums ){
            if(hm.containsKey(val-1)){
                hm.put(val, false);
            }
        }
        int maxStartPoint  = 0;
        int maxLength = 0;
        for(int val: nums){
            if(hm.get(val) == true){
                int length = 1;
                int startingPoint = val;
                while(hm.containsKey(startingPoint + length)){
                    length++;
                }
                if(length> maxLength){
                    maxStartPoint = startingPoint;
                    maxLength = length;
                }

            }

        }

        return maxLength;
	}
	
	public static void main(String[]args){
	  int []nums = {2,20,4,10,3,4,5};
	  LongestConsecutiveSequence lcs=new LongestConsecutiveSequence();
	  System.out.println(lcs.longestConsecutive(nums));
	  System.out.println(lcs.longestConsecutive1(nums));
	}
}