import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int num : tangerine){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(((o1, o2) -> map.get(o2) - map.get(o1)));
        
        for(Integer num : keyList){
            if(k <= 0){
                break;
            }
            answer++;
            k -= map.get(num);
        }
        
        return answer;
    }
}