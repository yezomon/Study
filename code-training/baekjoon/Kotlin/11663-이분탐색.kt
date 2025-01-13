import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
import kotlin.text.toInt

// 11663
// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
   val br = BufferedReader(InputStreamReader(System.`in`))
   val bw = BufferedWriter(OutputStreamWriter(System.out))
   val (n, m) = br.readLine().split(' ').map { it.toInt() }
   val p = br.readLine().split(' ').map { it.toLong() }.sorted() // 점들을 미리 정렬
   
   repeat(m) {
       val (start, end) = br.readLine().split(' ').map { it.toLong() }
       // lowerBound와 upperBound를 이용해 범위 내 점의 개수를 구함
       val lower = p.lowerBound(start)
       val upper = p.upperBound(end)
       bw.write("${upper - lower}\n")
   }
   bw.flush()
   bw.close()
}

// 이진 탐색으로 lower bound를 찾는 확장 함수
fun List<Long>.lowerBound(target: Long): Int {
    var low = 0
    var high = size
    while (low < high) {
        val mid = (low + high) / 2
        if (this[mid] < target) low = mid + 1
        else high = mid
    }
    return low
}

// 이진 탐색으로 upper bound를 찾는 확장 함수
fun List<Long>.upperBound(target: Long): Int {
    var low = 0
    var high = size
    while (low < high) {
        val mid = (low + high) / 2
        if (this[mid] <= target) low = mid + 1
        else high = mid
    }
    return low
}
