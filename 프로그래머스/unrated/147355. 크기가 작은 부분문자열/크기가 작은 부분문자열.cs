using System;
using System.Collections.Generic;

public class Solution {
    public int solution(string t, string p) {
        int answer = 0;
        
        List<string> num=new List<string>();
        
        for(int i=0; i<=t.Length-p.Length; i++) 
        {
            string str = t.Substring(i, p.Length);
            num.Add(str);
        }
        
        for(int i=0; i<num.Count; i++)
        {
            if(Convert.ToInt64(num[i]) <= Convert.ToInt64(p))
            {
                answer++;
            }
        }
        
        return answer;
    }
}