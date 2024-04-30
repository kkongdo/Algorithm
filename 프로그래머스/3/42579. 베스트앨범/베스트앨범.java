import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> maps = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            maps.put(genres[i], maps.getOrDefault(genres[i], 0) - plays[i]);
        }
        List<Map.Entry<String, Integer>> entries = maps.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());
        
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<int[]> playList;
        
        for(Map.Entry<String, Integer> entry : entries){
            playList = new ArrayList<>();
            
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(entry.getKey()))
                    playList.add(new int[]{plays[i], i});
            }
            
            playList.sort((o1, o2) -> o2[0] - o1[0]);
            
            result.add(playList.get(0)[1]);
            if(playList.size() > 1)
                result.add(playList.get(1)[1]);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}