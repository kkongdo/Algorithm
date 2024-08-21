class Solution {
    fun solution(numbers: IntArray): Double {
        var answer: Double = 0.0
        for(num in numbers){
            answer += num
        }
        return answer / numbers.size
    }
}