using System;
using System.Linq;
using System;
using System.Linq;

public class Solution {
    public string solution(string s) {
        string answer = "";
        var str=from item in s orderby item descending  select item ;
        foreach(var item in str)
        {
            answer+=item;
        }
        return answer;
    }
}