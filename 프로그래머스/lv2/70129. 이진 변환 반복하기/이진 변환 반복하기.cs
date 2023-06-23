using System;

public class Solution {
    public int[] solution(string s) {
        int[] answer = new int[2];
        int zeroCount=0,conversionCount=0;
        
        while(s.Length!=1)
        {
            int oneCount=0;
            
            foreach(var c in s)
            {
                if(c=='0')
                {
                    zeroCount++;
                }
                else
                {
                    oneCount++;
                }
            }
            s=Convert.ToString(oneCount,2);
            conversionCount++;
        }
        
        answer[0]=conversionCount;
        answer[1]=zeroCount;
        
        return answer;
    }
}