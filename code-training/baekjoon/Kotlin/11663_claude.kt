import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    
    val nm = br.readLine().split(' ')
    val n = nm[0].toInt()
    val m = nm[1].toInt()
    var p = br.readLine().split(' ').map{it.toLong()}.sorted()
    
    for(i in 0 until m) {
        val (start, end) = br.readLine().split(' ').map{it.toLong()}
        
        // 시작점의 lower bound를 찾음
        var left = 0
        var right = n - 1
        var startIdx = n
        while(left <= right) {
            val mid = (left + right) / 2
            if(p[mid] >= start) {
                startIdx = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        
        // 끝점의 upper bound를 찾음
        left = 0
        right = n - 1
        var endIdx = -1
        while(left <= right) {
            val mid = (left + right) / 2
            if(p[mid] <= end) {
                endIdx = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        val result = if(startIdx <= endIdx) endIdx - startIdx + 1 else 0
        bw.write("$result\n")
    }
    
    bw.flush()
    bw.close()
    br.close()
}
