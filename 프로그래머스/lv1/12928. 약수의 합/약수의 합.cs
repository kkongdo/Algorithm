public class Solution 
{
    public int solution(int n) 
    {
        int answer = 0;
        if(n>=1 && n<=3000)
        {
         for(int i=0; i<=n; i++)
         {
            if(i==0)
            {
                continue;
            }
            else if(n%i==0)
            {
                answer+=i;
            }
         }
        }    
        return answer;
    }
}