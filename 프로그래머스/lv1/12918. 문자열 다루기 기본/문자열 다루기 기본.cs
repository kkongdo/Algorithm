using System;

public class Solution {
    public bool solution(string s) {
        bool answer = true;
        int len=s.Length;
        
        if(len==4 || len==6)
        {
            foreach(var c in s)
            {
                if(!(char.IsDigit(c)))
                {
                    answer=false;
                }
            }
        }
        else
            answer=false;
        
        return answer;
    }
}