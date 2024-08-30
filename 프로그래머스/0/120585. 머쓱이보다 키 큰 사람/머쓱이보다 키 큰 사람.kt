class Solution {
    fun solution(array: IntArray, height: Int): Int {
        var answer: Int = 0
        array.forEach { number ->
            if(number > height){
                answer++
            }
        }
        return answer
    }
}