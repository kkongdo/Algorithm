class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] checked = new boolean[computers.length];
        
        for(int i = 0; i < n; i++){
            if(!checked[i]){
                dfs(i, checked, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] checked, int[][] computers){
        checked[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(!checked[i] && computers[node][i] == 1){
                dfs(i, checked, computers);
            }
        }  
    }
}