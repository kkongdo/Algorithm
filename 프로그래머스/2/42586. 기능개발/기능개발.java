import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> wating = new LinkedList<Integer>();
        for(int i = 0; i < progresses.length; i++){
            wating.offer( (int)(Math.ceil((100.0 - progresses[i]) / speeds[i] )));
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!wating.isEmpty()){
            int num = wating.poll();
            int count = 1;
            while(!wating.isEmpty() && num >= wating.peek()){
                count++;
                wating.poll();
            }
            list.add(count);
        }
        return list;
    }
}