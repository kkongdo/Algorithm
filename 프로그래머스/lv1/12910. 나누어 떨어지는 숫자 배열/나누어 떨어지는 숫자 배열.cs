using System;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = new int[] {};
        int[] tmp=new int[]{};
        
        tmp=new int[arr.Length];
        int count=0;
        
        for(int i=0; i<arr.Length; i++)
        {
            if(arr[i]%divisor==0)
            {   
                tmp[i]=arr[i];
                count++;
            }
        }
        
        
        
        Array.Sort(tmp);
        Array.Reverse(tmp);
        
        
        answer=new int[count];
        
        if(count==0)
        {
            answer=new int[1];
            answer[0]=-1;
        }
        
        for(int i=0; i<answer.Length; i++){
            if(tmp[i]>0){
                answer[i]=tmp[i];
            }
        }
        
        Array.Sort(answer);
        
        return answer;
    }
}