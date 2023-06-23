public class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] num=new int[n+1];
        
        //모듈러 연산 (A + B) % C ≡ ( ( A % C ) + ( B % C) ) % C
        //001235
        for(int i=0; i<=n; i++)
        {
            if(i==0)
            {
                num[i]=0;
            }
            else if(i==1)
            {
                num[i]=1;
            }
            else if(i>1)
            {
                num[i]=(num[i-2]%1234567)+(num[i-1]%1234567);
            }       
        }
        answer=num[n]%1234567;
        return answer;
    }
}