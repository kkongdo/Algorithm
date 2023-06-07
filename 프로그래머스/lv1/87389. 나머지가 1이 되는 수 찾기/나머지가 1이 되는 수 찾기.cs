using System;

public class Solution {
    public int solution(int n) {
        int answer = 0, i=1;
        
        while(n>=3 && n<=1000000)
        {         
           while(i>=1)
           {
             if(n%i==1)
             {
                 answer=i;
                 break;
             }
               i++;
           } 
            break;
        }
        return answer;
    }
}