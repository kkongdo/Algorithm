import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> city;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        city = new ArrayList<String>();
    
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(city);
        
        return city.get(0).split(" ");
    }
    static void dfs(int depth, String start, String path, String[][] tickets){
        if(depth == tickets.length){
            city.add(path);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && start.equals(tickets[i][0])){
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}