using System;

public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long tmp=0;
        
        if(a==b){
            answer=a;
        }
        else{
            for(int i=a;i<=b;i++){
                tmp+=i;
 
            }
            for(int i=b;i<=a;i++){
                tmp+=i;
            
            }
                answer=tmp;
        }  
        return answer;
    }
}