using System;
using System.Collections;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int num=n;
        string ternary="";
        
        while(num>0)
        {
            ternary=ternary+Convert.ToString(num%3);
            num/=3;
        }
        int j=0;
        for(int i=ternary.Length-1; i>=0;i--)
        {
            int pow=Convert.ToInt32(Math.Pow(3,j));
            answer+=(int)char.GetNumericValue(ternary[i])*pow;
            j++;
        }
       return answer;
    }
}