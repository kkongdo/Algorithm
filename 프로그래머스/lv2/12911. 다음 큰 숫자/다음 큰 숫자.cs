using System;

class Solution 
{
    public int solution(int n) 
    {
        int count = CountOne(n);
        int next = n + 1;

        while (CountOne(next) != count)
        {
            next++;
        }
        return next;
    }
    
    //이진수 1의 갯수를 세는 방법
    private int CountOne(int num)
    {
        int count = 0;
        while (num != 0)
        {
            count++;
            num &= (num - 1);
        }
        return count;
    }
}