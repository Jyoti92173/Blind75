/*Problem Statement: Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.
A substring is a contiguous sequence of characters within a string.*/

class StringMatch {
    public  static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
            for(int j = 0; j<words.length; j++){
                if(i!=j && words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }
	public boolean isSubString(String[] words, int idx){
		for(int j = 0; j<words.length; j++){
                if(idx!=j && words[j].contains(words[idx])){
                    return true;
                }
            }
            return false;
	}
	 public  static List<String> stringMatching1(String[] words) {
		  List<String> result = new ArrayList<>();
        for(int i = 0; i<words.length; i++){
			if(isSubString(words,0)){
				result.add(words[i]);
			}
		return result
		}
	 }
	public static void main(String [] args){
		String []words = {"mass","as","hero","superhero"};
		System.out.println(stringMatching(words));
		System.out.println(stringMatching1(words));
	}
}