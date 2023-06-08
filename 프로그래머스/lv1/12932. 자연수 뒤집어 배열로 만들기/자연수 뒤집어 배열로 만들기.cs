using System;

public class Solution {
    public int[] solution(long n) {
        int[] answer = new int[] {};
        
        string tmp=n.ToString();
        int i=0,Len=tmp.Length;
        answer=new int[Len];
        
        while(n>0)
        {
            answer[i]=(int)(n%10);
            n/=10;
            if(n==0)
                break;
            i++;
        }
        return answer;
    }
}