class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(true){
            StringBuilder sb = new StringBuilder();
            char[] ch = s.toCharArray();
            for(int i = 0; i < ch.length; i++){
                if(ch[i] != '0'){
                    sb.append(ch[i]);
                    continue;
                }
                answer[1]++;
            }
            int len = sb.toString().length();
            String str = Integer.toString(len,2);
            
            answer[0]++;
            if(str.equals("1")){
                break;
            }
            s = str;
        }
        return answer;
    }
}