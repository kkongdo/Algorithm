class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        var answer: Int = 0
        for(tmp1 in s1){
            for(tmp2 in s2){
                if(tmp1.equals(tmp2)){
                    answer++
                }
            }
        }
        return answer
    }
}