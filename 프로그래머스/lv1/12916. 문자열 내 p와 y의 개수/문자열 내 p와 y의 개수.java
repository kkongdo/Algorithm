class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int[] count = new int[2];
        
        char[] ch = s.toUpperCase().toCharArray();
        
        for(int i = 0; i< ch.length; i++){
            if(ch[i] == 'P'){
                count[0]++;
                continue;
            }
            if(ch[i] == 'Y'){
                count[1]++;
                continue;
            }
        }
       if(count[0] != count[1]){
           answer = false;
       }
        return answer;
    }
}