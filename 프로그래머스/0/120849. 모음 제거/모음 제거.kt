class Solution {
    fun solution(my_string: String): String {
        var answer = StringBuilder()
        my_string.forEach{ ch -> 
            if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                answer.append(ch)
            }
        }
        return answer.toString()
    }
}