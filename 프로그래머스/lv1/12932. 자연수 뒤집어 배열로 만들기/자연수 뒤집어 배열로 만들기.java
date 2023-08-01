class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String s = new StringBuilder(str).reverse().toString();
        char[] tmp = s.toCharArray();
        int[] answer = new int[tmp.length];
        
        for(int i = 0; i < answer.length; i++){
           answer[i] = tmp[i] -'0';
        }
        return answer;
    }
}