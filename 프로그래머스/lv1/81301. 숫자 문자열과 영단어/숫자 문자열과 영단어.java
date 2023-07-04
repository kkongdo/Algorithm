class Solution {
    public int solution(String s) {
        int answer = 0;        
        StringBuilder str=new StringBuilder(s);
        String[] strNum={"zero","one", "two", "three", "four","five","six","seven","eight","nine"};
        
        for(int i=0; i<strNum.length; i++)
        {
            s=s.replace(strNum[i],Integer.toString(i));
        }
            
        answer=Integer.parseInt(s);
        return answer;
    }
}