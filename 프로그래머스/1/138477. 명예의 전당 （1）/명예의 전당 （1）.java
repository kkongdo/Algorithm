import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> result = new PriorityQueue<Integer>();
        int tmp = 0;
        
        for(int i = 0; i < score.length; i++){
            result.add(score[i]);
            
            if(result.size() > k){
                result.poll();
            }
            
            answer[i] = result.peek();
        }
        
        return answer;
    }
}