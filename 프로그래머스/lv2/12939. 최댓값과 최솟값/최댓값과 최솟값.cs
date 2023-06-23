using System;
using System.Collections;
using System.Linq;
using System.Collections.Generic;

public class Solution {
    public string solution(string s) {
        
        string answer = "";
        int[] nums=s.Split().Select(int.Parse).ToArray();
        answer=$"{nums.Min()} {nums.Max()}";
        return answer;
    }
}