/*
Problem Statement: Given a string s, return true if it is a palindrome, otherwise return false.
A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
*/

class PallindromeStringOrNot {
	//Approach 1:Using Two Pointer .....
    public boolean isPalindrome(String s) {
        if(s.isEmpty())
        return false;
        StringBuilder str1=new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                str1.append(Character.toLowerCase(c));
            }
        }
        String filteredStr=str1.toString();
        int left=0;
        int right=filteredStr.length() - 1;
        while(left<right){
            if(filteredStr.charAt(left)!= filteredStr.charAt(right)){
                return false;
            }
         left++;
        right--;
        }
        
        return true;
    }
	public static void main(String[] args){
		isPalindrome pd= new isPalindrome();
		String s="Was it a car or a cat I saw?";
		System.out.println(pd.isPalindrome(s));
	}
}
