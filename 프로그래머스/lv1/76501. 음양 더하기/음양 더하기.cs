using System;

public class Solution {
    public int solution(int[] absolutes, bool[] signs) {
        int answer = 123456789;
        int[] num=absolutes;
        bool[] sign=signs;
        int tmp=0;
        
        for(int i=0; i<num.Length; i++)
        {
            if(sign[i]==true)
            {
                tmp+=num[i];
            }
            else
                tmp-=num[i];
        }
        answer=tmp;
        return answer;
    }
}