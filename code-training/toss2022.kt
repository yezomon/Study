//멋쟁이
class Solution {
    fun solution(s: String): Int {
        var biggest = -1
        for (i in 0 until s.length-2) {
            if (s[i] == s[i+1] && s[i+1] == s[i+2]) {
                biggest = Math.max(biggest, s.substring(i, i+3).toInt())
            }
        }
        return biggest
    }
}
