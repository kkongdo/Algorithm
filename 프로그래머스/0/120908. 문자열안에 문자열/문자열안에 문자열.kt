class Solution {
    fun solution(str1: String, str2: String): Int {
        if (str2.isEmpty()) 
            return 1
        for (i in 0..(str1.length - str2.length)) {
            val subStr = str1.substring(i, i + str2.length)
            if (subStr == str2) {
                return 1
            }
        }
        return 2
    }
}
