class Solution {
    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
        var numerator:Int = (numer1 * denom2) + (numer2 * denom1)
        var denominator:Int = denom1 * denom2
     
        var gcd:Int = gcd(numerator, denominator)
        
        numerator /= gcd
        denominator /= gcd
        return intArrayOf(numerator, denominator)
    }
    private fun gcd(a:Int, b:Int):Int{
        if(b==0)
            return a
        return gcd(b, a%b)
    }
}