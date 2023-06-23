using System;
using System.Linq;

public class Solution {
    public string solution(string s) {
        string answer = "";
        char[] str=s.ToCharArray();
        int len=s.Length, tmp;
        
        //12345678 => n,n-1;
        //01234 0123456
     
        if(len%2==0)
        {
            tmp=len/2;
            answer=str[tmp-1].ToString()+str[tmp].ToString();
        }
        else
        {
            tmp=len/2;
            answer=str[tmp].ToString();
        }
    
        return answer;
    }
}