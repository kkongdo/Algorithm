using System;
using System.Collections.Generic;

public class Solution {
    public bool solution(string s) {
        bool answer = true;

        var stack = new Stack<char>();

        foreach (char c in s)
        {
            if (c == '(') 
            {
                stack.Push(c);
            }
            else if (c == ')') 
            {
                if (stack.Count == 0 || stack.Pop() != '(') 
                {
                    answer=false;
                    return answer;
                }
            }
        }

        return stack.Count == 0;
    }
}
