class Solution {
    fun solution(n: Int): Int {
        return if (n % 6 == 0) n / 6 else (n * 6) / gcd(n, 6) / 6
    }
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}