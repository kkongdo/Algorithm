class Solution {
    fun solution(array: IntArray): Int {      
        val frequencyMap = array.toList().groupingBy { it }.eachCount()
        val maxFrequency = frequencyMap.maxOf { it.value }
        val modeList = frequencyMap.filter { it.value == maxFrequency }.keys
        
        return if (modeList.size > 1) {
            -1 
        } else {
            modeList.first()
        }
    }
}
