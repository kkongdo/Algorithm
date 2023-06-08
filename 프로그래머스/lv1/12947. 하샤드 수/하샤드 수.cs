using System;

public class Solution {
    public bool solution(int x) {
        bool answer = true;
        
        string str=x.ToString();
        int[] num=new int[str.Length];
        int sum=0,count=0,tmp=x;
        
        while(x>0){
            num[count]=x%10;
            x/=10;
            count++;
        }
        
        for(int i=0; i<str.Length; i++){
            sum+=num[i];
        }
        
        if(tmp%sum==0)
            answer=true;
        else
            answer=false;
        
        return answer;
        
    }
}