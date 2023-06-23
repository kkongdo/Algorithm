using System;

public class Solution {
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        
        Array.Sort(A);
        Array.Sort(B);
        
        int num=0;
        
        for(int i=0; i<A.Length; i++)
        {
             num=num+A[i]*B[(B.Length-1)-i];
        }
        answer=num;
     
        return answer;
    }
}