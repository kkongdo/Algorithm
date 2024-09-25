class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var odd: String = ""
        var even: String = ""
        num_list.forEach{ n ->
            if(n % 2 == 0){
                even += n.toString()
            }
            else{
                odd += n.toString()
            }
        }
        answer = even.toInt() + odd.toInt()
        return answer
    }
}