class Solution {
    fun solution(num: Int, k: Int): Int {
        var answer: Int = 0
        num.toString().forEach{ n -> 
            if(n.toString().toInt() == k)
                return answer + 1
            else
                answer++
        }
        return -1
    }
}