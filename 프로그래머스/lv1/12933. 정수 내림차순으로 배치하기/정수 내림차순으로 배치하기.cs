using System;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        
        string str=n.ToString();
        char[] charArray=str.ToCharArray();
        
        Array.Sort(charArray);
        Array.Reverse(charArray);
        
        str=new string(charArray);
        answer=Convert.ToInt64(str);
        return answer;
    }
}