import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.*

//11728
fun main() {
    //var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
  val (n, m) = readLine()!!.split(" ").map { it.toInt() }
  val a = readLine()!!.split(" ").map { it.toInt() }
  val b = readLine()!!.split(" ").map { it.toInt() }
  val arr :LinkedList<Int> = LinkedList<Int>()//ArrayList<Int>(n+m)
  //val dnaList = List(n) { readLine()!! }
  a.map { arr.add(it.toInt()) }
  b.map { arr.add(it.toInt()) }
  arr.sort()
  bw.write("${arr.joinToString(" ")}")
  bw.flush()
  bw.close()
}
