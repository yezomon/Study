import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// Todo.
// 30088
// 그냥 각 부서의 면담시간 합이 최소인 순서대로 하면은 되는거같은데
// 부서수 1000 직원수 총합 1,000,000 면담시간 1000
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()
  // var h = Regex(Regex.escape(":-)")).findAll(n).count() //contains("1")
  // var uh = Regex(Regex.escape(":-(")).findAll(n).count()
  val t = br.readLine().toInt() // .split(' ').map{it.toInt()} // n, t
  // var arr = Array(s[0].toInt()+2) { 0.toLong() } //LinkedList<ab>() //List(n[0]) { 0
  // }//Array(n[0]) { 0 } 이것은 뮤터블인가 아닌
  // var arr = Array(15) { Array(15) { 0 } }
  // 72 - 15 1/1/1
  var arr = MutableList<Long>(0) { 0 }
  repeat(t) {
    // var n = br.readLine().toInt()
    var s = br.readLine().split(' ').map { it.toInt() } // .toMutableList() //.map{it.toInt()} r,c
    var r : Long = s.sumOf { it.toLong()  }
    //arr[r] += r-s[0]
    arr.add(r-s[0].toLong())
    // bw.write("Case #${c}: ${s.filter { it > 0 }.joinToString(" ")}\n")
    // var arr : Array<Int>//Array(s[0].toInt()){Array(s[1].toInt()) { -1 }}
  }
  arr.sort()
  var f :Long = 0
  var result = arr.fold(0L) { acc, num ->
    f += num
    //bw.write("${acc}  ${f}  ${num} \n")
    acc+f
  }
  bw.write("${result}")
  //bw.write("${arr.joinToString()}\n")
  bw.flush()
  bw.close()
}

// tailrec fun factorial(n: Int, result: Long = 1): Long {
//     if (n == 1) return result
//     return factorial(n - 1, n * result)
// }
// fun findM() : Boolean{
// }
