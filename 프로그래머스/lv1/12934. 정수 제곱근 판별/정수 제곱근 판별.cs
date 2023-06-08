using System;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        double item=Math.Sqrt(n);
        
        answer= item%1==0 ? (long)((item+1)*(item+1)) : (long)-1;
        
        return answer;
    }
}