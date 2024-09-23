import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int s : scoville) {
            queue.offer(s);
        }
        if(queue.peek() >= K){
            return answer;
        }

        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            int newScoville = first + second * 2;
            queue.offer(newScoville);
            answer++;
            
            if (queue.peek() >= K) {
                return answer;
            }
        }

        return queue.peek() >= K ? answer : -1;
    }
}

class Food implements Comparator<Food> {
    int value;
    
    public Food(int value) {
        this.value = value;
    }
    
    @Override
    public int compare(Food o1, Food o2) {
        return Integer.compare(o1.value, o2.value);
    }
}
