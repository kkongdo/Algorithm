public class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int num1=n;
        int num2=m;
        
        while(num2!=0)
        {
            int tmp=num1%num2;
            num1=num2;
            num2=tmp;
        }
        answer[0]=LCM(n,m); 
        answer[1]=n*m/LCM(n,m);
        
        return answer;
    }
    
    public int LCM(int a, int b)
    {
        if(b==0)
            return a;
        return LCM(b,a%b);
    }
}