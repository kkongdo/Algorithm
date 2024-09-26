class Solution {
    fun solution(my_string: String, letter: String): String {
        var answer: String = ""
        my_string.forEach{ ch ->
            if(ch.toString() != letter){
                answer += ch
            }
        }
        return answer
    }
}