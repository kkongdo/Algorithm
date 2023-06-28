using System;

public class Solution {
    public string solution(string s) {
        string answer = "";
        string[] str=s.Split(' ');
        
        for(int i=0; i<str.Length; i++)
        {
            char[] chr = str[i].ToCharArray();
            for(int j=0; j<chr.Length;j++)
            {
                if(j%2==0)
                {
                    chr[j]=char.ToUpper(chr[j]);
                }
                else
                    chr[j]=char.ToLower(chr[j]);
            }
            str[i]=new String(chr);
        }
        answer = string.Join(" ", str);
        return answer;
    }
}