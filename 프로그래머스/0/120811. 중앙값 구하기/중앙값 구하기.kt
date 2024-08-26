class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        var nums = array.sorted()
        var mid = nums.size / 2
        answer = nums[mid]
        return answer
    }
}