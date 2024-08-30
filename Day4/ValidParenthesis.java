/*
Problem Statement: You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
   The input string s is valid if and only if:
   Every open bracket is closed by the same type of close bracket.
   Open brackets are closed in the correct order.
   Every close bracket has a corresponding open bracket of the same type.
   Return true if s is a valid string, and false otherwise.
*/
class ValidParenthesis {
    public boolean isValid(String s) {
		//Approach 1: using a stack along with a switch case.......
         Stack<Character> stack = new Stack<>();
         for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
	  public boolean isValid1(String s) {
		  // Approach 2: Using Stack.....
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            } 
            else {
                return false;
            }
        }
        
        return stack.isEmpty(); 
	  }
	  // Time complexity: O(n)
	  // Space Complexity: O(n)
	   public static void main(String[] args){
		  isValid isvalid=new isValid();
		  String s = "([{}])";
		  System.out.println(isvalid.isValid(s));
		  System.out.println(isvalid.isValid1(s));
	    }
}
