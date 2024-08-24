/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
  */
public class ReverseVowels {
    // Approach 1: Two Pointer 
        public String reverseVowels(String s) {
            char [] word=s.toCharArray();
            int start=0; 
            int end=s.length()-1;
            while(start<end){
                if(word[start]=='a' || word[start]=='e' || word[start]=='i'|| word[start]=='o'|| word[start]=='u'){
                    if(word[end]=='a' || word[end]=='e' || word[end]=='i' || word[end]=='o' || word[end]=='u'){
                        char temp= word[start];
                        word[start]=word[end];
                        word[end]=temp;
                        start++;
                        end--;
                    }
                    else{
                        end--;
                    }
                }
                else{
                    start++;
                }
            }
            return String.valueOf(word);
        }
    }
    // Approach 2: This is also a Pointer approach but in this approach i used this some different way
    class Solution {
        public String reverseVowels(String s) {
            Set<Character> set = Set.of('a','e','i','o','u','A','E','I','O','U');
            
            int i = 0, j = s.length() - 1;
            char[] chars = s.toCharArray();
    
            while (i < j) {
                while (i < j && !set.contains(chars[i])) i++;
                while (i < j && !set.contains(chars[j])) j--;
    // Swap the Vowels 
                char temp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = temp;
            }
    
            return new String(chars);
        }
    }

