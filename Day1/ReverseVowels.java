class ReverseVowels {
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
    public static void main(String []args){
        ReverseVowels rv=new ReverseVowels();
        String s="hello";
        System.out.println(rv.reverseVowels(s));
    }
}