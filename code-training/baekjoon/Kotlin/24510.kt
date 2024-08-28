import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    var max = 0

    repeat(n) {
        val s = br.readLine()
        val count = countOccurrences(s)
        if (count > max) {
            max = count
        }
    }

    bw.write("$max")
    bw.flush()
    bw.close()
}

fun countOccurrences(s: String): Int {
    var count = 0
    var i = 0
    while (i < s.length) {
        when {
            s.startsWith("for", i) -> {
                count++
                i += 3
            }
            s.startsWith("while", i) -> {
                count++
                i += 5
            }
            else -> i++
        }
    }
    return count
}
/*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt()
  var max = 0 // Integer.MIN_VALUE
  repeat(n) {
    var s = br.readLine()
    var f = s.indices.count { s.indexOf("for", it) == it } //매 인덱스마다 indexOf를 호출합니다. indexOf는 매번 문자열의 처음부터 검색을 시작합니다.(시간초과)  
    var w = s.indices.count { s.indexOf("while", it) == it }
    if (f + w > max) {
      max = f + w
    }
  }
  // val h = br.readLine().split(' ').map { it.toInt() } //

  bw.write("${max}")
  bw.flush()
  bw.close()
}
*/
