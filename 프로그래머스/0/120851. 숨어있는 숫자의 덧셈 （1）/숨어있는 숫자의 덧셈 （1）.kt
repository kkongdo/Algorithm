class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        my_string.forEach{ ch ->
            if(ch in '0'..'9'){
                answer += ch.toString().toInt()
            }
        }
        return answer
    }
}