public class Solution {
    public int solution(int num) {
        int answer = 0;
        long tmp=num; // long 자료형을 사용해주어야한다.
        
        if(num==1)
        {
            answer=0;
        }
        else
        {
            while(tmp>1)
            {
                if(answer==500){
                    answer=-1;
                    break;
                }
                else if(tmp%2==0){
                    tmp/=2;
                    answer++;
                }
                else if(tmp%2==1){
                    tmp=(tmp*3)+1;
                    answer++;
                }
            }  
        }
        return answer;
    }
}