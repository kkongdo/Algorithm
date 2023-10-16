import java.util.*;

class Solution {
    private static final char[] chars = "AEIOU".toCharArray();
    
    private void generate(String word, List<String> words){
        words.add(word);
        if(word.length() ==5)
            return;
        for(char ch : chars){
            generate(word + ch, words);
        }
    }
    
    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }   
}