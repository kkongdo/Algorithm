import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer=new int[2];
        
        HashSet<String> usedWords = new HashSet<>();
        
        int roundCount=1;
        int playerNumber=1;

        for (int i=0; i<words.length; i++) 
        {
            String currentWord=words[i];

            if (i>0&&(currentWord.charAt(0)!=words[i-1].charAt(words[i-1].length()-1)||usedWords.contains(currentWord))) 
            {
                answer[0] = playerNumber;
                answer[1] = roundCount;
                return answer;
            }

            usedWords.add(currentWord);
            playerNumber++;

            if (playerNumber>n) 
            {
                playerNumber=1;
                roundCount++;
            }
        }

        answer[0]=0;
        answer[1]=0;
        return answer;
    }
}
