import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// with claude. 
// 2992
// 순열? 조합? 
var n : Int = -1
var list = LinkedList<Int>()
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var s = br.readLine()
  n = s.toInt()
  var ss = s.toCharArray()
  val visited = BooleanArray(ss.size) { false }
  val output = IntArray(ss.size)
  //combinationNum(n.map { it.code-'0'.code }.toIntArray(), visited, 0, n.size, n.size)
  var p =  permutation(ss.map { it.code-'0'.code }.toIntArray(), output, visited, 0)
  //bw.write(ss.size.toString()+"\n")
  //bw.write("$n")
  list.sortDescending()
  
  val upperBound = list.sorted().find { it > n } ?: 0 //list.sortedDescending().find { it < n } ?: -1
   bw.write("$upperBound")
  bw.flush()
  bw.close()
}

fun permutation(arr: IntArray, output: IntArray, visited: BooleanArray, depth: Int) {
   if (depth == arr.size) {
       //println(output.joinToString(" "))
       list.add(output.joinToString("").toInt())
       return
   }

   for (i in arr.indices) {
       if (!visited[i]) {
           visited[i] = true
           output[depth] = arr[i]
           permutation(arr, output, visited, depth + 1)
           visited[i] = false
       }
   }
}
