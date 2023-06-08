import java.lang.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String str=s.toUpperCase();
        char[] charArray=new char[str.length()];
        int cnt1=0,cnt2=0;
        
        for(int i=0; i<str.length(); i++)
        {
            charArray[i]=str.charAt(i);
        }
        
        for(int i=0; i<str.length(); i++)
        {
            if(charArray[i]=='P')
            {
                cnt1++;
            }
            else if(charArray[i]=='Y')
            {
                cnt2++;
            }
        }
        
        if(cnt1==cnt2)
        {
            answer=true;
        }
        else
        {
            answer=false;
        }
        

        return answer;
    }
}