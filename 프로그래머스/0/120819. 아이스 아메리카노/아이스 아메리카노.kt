class Solution {
    fun solution(money: Int): IntArray {
        val count = money / 5500   
        val remainder = money % 5500

        return intArrayOf(count, remainder)
    }
}