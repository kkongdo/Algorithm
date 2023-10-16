class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int length = food.length;
        for(int i = 1; i < length; i++){
            int value = food[i] / 2;
            for(int j = 0; j < value; j++){
                sb.append(i);
            }
        }
        answer = sb.toString() + 0 + sb.reverse().toString();
        return answer;
    }
}