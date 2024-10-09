class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            int newCoke = (n / a) * b;
            n = (n % a) + newCoke;
            answer += newCoke;
        }
        return answer;
    }
}