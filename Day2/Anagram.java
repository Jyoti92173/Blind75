/*
Problem Statement: Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
*/
class Anagram {
		//Approach 1: Brute Force
    public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()){
			return false;1
		}
		int []sCount=new int[26];
		int []tCount=new int[26];
		for(int i=0; i<s.length(); i++){
			sCount[s.charAt(i) - 'a']++;
			tCount[t.charAt(i) - 'a']++;
		}
		for(int i=0; i<26; i++){
			if(sCount[i]!=tCount[i]){
				return false;
			}
		}
		return true;
    }
	//Time Complexity: O(n)
	//Space Complexity: O(1)
	
	//Approach 2: Two Pointer with Sorting
    public boolean isAnagram1(String s, String t) {	
		if(s.length()!=t.length()){
			return false;
		}
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		return Arrays.equals(sArray, tArray);
    }
	public static void main(String[] args){
		Anagram an=new Anagram();
		String s = "racecar";
		String t = "carrace"
		System.out.println(an.isAnagram(s,t));
		System.out.println(an.isAnagram1(s,t));
	}
		// Time Complexity: O(nlogn)
	   // Space Complexity: O(n)
	
  }
