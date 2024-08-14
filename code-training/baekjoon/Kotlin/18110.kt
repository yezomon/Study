import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// Todo. sortWith, sort, reverse, sortDescending, SortBy
// 18110

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()
  // var h = Regex(Regex.escape(":-)")).findAll(n).count() //contains("1")
  // var uh = Regex(Regex.escape(":-(")).findAll(n).count()
  val n = br.readLine().toInt()
  // var arr = Array(s[0].toInt()+2) { 0.toLong() } //LinkedList<ab>() //List(n[0]) { 0
  // }//Array(n[0]) { 0 } 이것은 뮤터블인가 아닌
  // var arr = Array(15) { Array(15) { 0 } }
  //var m = Integer.MIN_VALUE
  //var s = br.readLine().split(' ').map { it.toInt() }.toTypedArray() // n개
  var arr = MutableList<Int>(0) { 0 }
  //bw.write("${s.joinToString()}\n")
  repeat(n){
    var q = br.readLine().toInt()
    arr.add(q)
  }
  arr.sort()
  var c = Math.round(n.toFloat() * 0.15).toInt()
  arr.subList(0, c).clear()
  arr.subList(arr.size-c, arr.size).clear()
  // var p = s.toMutableList().sortedDescending().take(t[1]).toTypedArray().sumOf { it }
  //bw.write("${c}\n")
  bw.write("${Math.round(arr.average())}")
  bw.flush()
  bw.close()
}
