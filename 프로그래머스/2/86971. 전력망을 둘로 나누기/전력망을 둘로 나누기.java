import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n + 1][n + 1];
        for(int i = 0; i < wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        for(int i = 0; i < wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            
            graph[from][to] = 0;
            graph[to][from] = 0;
            
            answer = Math.min(answer, bfs(n, from));
            
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        
        return answer;
    }
    
    public static int bfs(int n, int from){
        boolean[] visited = new boolean[n + 1];
        int count = 1;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[from] = true;
        queue.offer(from);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i = 1; i <= n; i++){
                if(graph[tmp][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }
        return (int)Math.abs(count - (n - count));
    }
}