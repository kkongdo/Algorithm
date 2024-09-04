class Solution {
    fun solution(message: String): Int {
        var answer: Int = 0
        message.forEach{ ch ->
            if(!ch.equals(" ")){
                answer++
            }
        }
        answer = answer * 2
        return answer
    }
}