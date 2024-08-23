import kotlin.math.*

class Solution {
    fun solution(n: Int): Int {
        var i = sqrt(n.toDouble()).toLong()
        var answer: Int = 0
        if(i * i == n.toLong()){
            answer = 1
        }
        else{
            answer = 2
        }
        return answer
    }
}