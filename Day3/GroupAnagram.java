/*
Problem Statement: Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
*/

class GroupAnagram {
	//Approach 1: Brute force...
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] grouped = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (grouped[i]) continue; 
            
            List<String> anagramGroup = new ArrayList<>();
            anagramGroup.add(strs[i]);
            grouped[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (!grouped[j] && areAnagrams(strs[i], strs[j])) {
                    anagramGroup.add(strs[j]);
                    grouped[j] = true;
                }
            }
            result.add(anagramGroup);
        }
        
        return result;
    }
    // Helper method to check if two strings are anagrams
    private boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
	
// Approach 2 : HashMap....
    public List<List<String>> groupAnagrams1(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
	public static void main(String []args){
		String strs[] = {"act","pots","tops","cat","stop","hat"};
		GroupAnagram gAnagram=new GroupAnagram();
		List<List<String>> result1 = gAnagram.groupAnagrams(strs);
		List<List<String>> result2 = gAnagram.groupAnagrams1(strs);
		System.out.println("Brute Force Approach:");
		System.out.println(resul1t1);
		System.out.println("HashMap Approach:");
		System.out.println(resul1t2);
	}
}
