import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
//         int[] answer = new int[commands.length];
        
//         for(int i = 0; i < commands.length; i++){
//             ArrayList<Integer> tmp = new ArrayList<Integer>();
//             for(int j = commands[i][0] - 1; j < commands[i][1]; j++){
//                 tmp.add(array[j]);
//             }
//             Collections.sort(tmp);
//             answer[i] = tmp.get(commands[i][2] -1);
//         }
//         return answer;
        int[] answer = new int[commands.length];
        for(int i = 0; i < answer.length; i++){
            int[] command = commands[i];
            int from = command[0] - 1;
            int to = command[1];
            int k = command[2] - 1;
            
            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[k];
        }
        return answer;
    }
}