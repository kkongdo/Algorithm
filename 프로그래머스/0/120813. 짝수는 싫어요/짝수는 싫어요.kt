class Solution {
    fun solution(n: Int): IntArray {
        var answer = mutableListOf<Int>()
        for(num in 1..n){
            if(num % 2 != 0){
                answer.add(num)
            }
        }
        return answer.sorted().toIntArray()
    }
}