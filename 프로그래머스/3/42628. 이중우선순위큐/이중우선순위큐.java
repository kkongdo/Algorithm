import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations){
            String[] op = operation.split(" ");
            String command = op[0];
            int num = Integer.parseInt(op[1]);

            if(command.equals("I")){
                minQueue.offer(num);
                maxQueue.offer(num);
            } 
            else if(command.equals("D")){
                if(num == 1 && !maxQueue.isEmpty()){
                    minQueue.remove(maxQueue.poll());
                } 
                else if(num == -1 && !minQueue.isEmpty()){
                    maxQueue.remove(minQueue.poll());
                }
            }
        }
        
        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.peek();
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.peek();

        return answer;
    }
}
