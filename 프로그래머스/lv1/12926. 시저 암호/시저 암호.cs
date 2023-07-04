using System;

public class Solution {
    public string solution(string s, int n) {
        string answer = "";
        char[] ch=s.ToCharArray();
        
        for(int i=0; i<s.Length; i++)
        {
            if(ch[i]!=' ')
            {
                char basechar=char.IsLower(ch[i]) ? 'a' : 'A';
                
                //문자 범위를 초과하는 것을 막고, 암호화 하는 공식
                ch[i]=(char)((ch[i]-basechar+n)%26+basechar);
            } 
        }
        answer=new string(ch);
        return answer;
    }
}