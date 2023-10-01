import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> number = new HashSet<Integer>();
        for(int i = 0; i < numbers.length; i++){
            for(int j = i +1 ; j < numbers.length; j++){
                number.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list = new ArrayList<Integer>(number);
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        int count = 0;
        for(int num : list){
            answer[count++] = num;
        }
        
        return answer;
    }
}