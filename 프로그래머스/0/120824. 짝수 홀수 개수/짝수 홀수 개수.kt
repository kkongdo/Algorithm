class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        for(num in num_list){
            if(num % 2 == 0){
                answer[0]++;
            }
            else{
                answer[1]++;
            }
        }
        return answer
    }
}