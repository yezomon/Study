import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// Todo. sortWith, sort, reverse, sortDescending, SortBy
// 5586
// indices는 0부터 시작하여 컬렉션의 마지막 인덱스까지의 범위를 제공합니다.
// withIndex()는 컬렉션의 각 요소와 그 인덱스를 함께 순회할 수 있게 해주는 함수입니다.
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()
  // var h = Regex(Regex.escape(":-)")).findAll(n).count() //contains("1")
  // var uh = Regex(Regex.escape(":-(")).findAll(n).count()
  val s = br.readLine() // .toInt()
  bw.write("${s.indices.count{s.indexOf ("JOI", it) ==it}}\n") // ("${Regex("JOI").findAll(s)}\n")
  bw.write("${s.indices.count{s.indexOf ("IOI", it) ==it}}")

  // var arr = Array(s[0].toInt()+2) { 0.toLong() } //LinkedList<ab>() //List(n[0]) { 0
  // }//Array(n[0]) { 0 } 이것은 뮤터블인가 아닌
  // var arr = Array(15) { Array(15) { 0 } }
  // var m = Integer.MIN_VALUE
  // var s = br.readLine().split(' ').map { it.toInt() }.toTypedArray() // n개
  // var arr = MutableList<Int>(0) { 0 }

  // var p = s.toMutableList().sortedDescending().take(t[1]).toTypedArray().sumOf { it }
  // bw.write("${c}\n")
  bw.flush()
  bw.close()
}
