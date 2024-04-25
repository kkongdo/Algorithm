class Solution {
    public int solution(int[] arr) {
      int answer = 0;
        
        if(arr.length == 1){
            return arr[0];
        }
        int g = GCD(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / g;
        
        if(arr.length > 2){
            for(int i = 2; i < arr.length; i++){
                g = GCD(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }
        return answer;
    }
    public static int GCD(int a, int b){
        int result = a % b;
        if(result == 0){
            return b;
        }
        else{
            return GCD(b, result);
        }
    }
}