class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    private void dfs(int[] numbers, int depth, int sum, int target){
        if(numbers.length == depth){
            if(sum == target){
                answer++;
            }
            return;
        }
        else{
            dfs(numbers, depth+1, sum + numbers[depth], target);
            dfs(numbers, depth+1, sum - numbers[depth], target);
        }
    }
}