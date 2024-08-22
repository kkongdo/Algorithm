class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        var num1 = 12000 * n
        var num2 = 2000 * k
        var num3 = n/10 * 2000
        answer = num1 + num2 - num3
        return answer
    }
}