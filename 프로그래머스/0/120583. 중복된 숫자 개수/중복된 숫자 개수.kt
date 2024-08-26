class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        array.forEach{ num -> 
            if(num == n){
                answer++;
            }
        }
        return answer
    }
}