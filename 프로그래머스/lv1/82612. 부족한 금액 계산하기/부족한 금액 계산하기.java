class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long mon=0;
        
        for(int i=1; i<=count; i++) //1234
        {
            mon+=(price*i); //3 
        }
        answer=(long)money-mon > 0 ? 0 : -(long)(money-mon);
        
        return answer;
    }
}