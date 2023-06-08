using System;

public class Solution {
    public string solution(string phone_number) {
        string answer = "";
        char[] ch=phone_number.ToCharArray();
        
        for(int i=0; i<phone_number.Length-4; i++){
            ch[i]='*';
        }
        answer=new string(ch);
        
        return answer;
    }
}