public class Solution {
    public string solution(string s) {
        string answer;
        char[] chr=s.ToLower().ToCharArray();
      
        
        for(int i=0; i<s.Length; i++)
        {
            if(i==0 && chr[i].GetType()==typeof(char))
            {
                chr[i]=char.ToUpper(chr[i]);
            }
            else if(chr[i]==' '&& i+1<s.Length)
            {
                chr[i+1]=char.ToUpper(chr[i+1]);
            }  
        }
        answer=new string(chr);
        
        return answer;
    }
}