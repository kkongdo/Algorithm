using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        int[] nums=arr;
        
        List<int> arrs=new List<int>();
        int min=Int32.MaxValue,n=0;
        
        for(int i=0; i<arr.Length; i++)
        {
            if(min>nums[i])
            {
                min=nums[i];
            }
        }
    
        for(int i=0; i<nums.Length; i++)
        {
            if(nums[i]==min)
                continue;
            else
                arrs.Add(nums[i]);
        }
        answer=new int[arrs.Count];
        
        foreach(var item in arrs)
        {
            answer[n]=item;
            n++;
        }
        
        if(arrs.Count==0)
        {
            answer=new int[1];
            answer[0]=-1;
        }
        
        return answer;
    }
}