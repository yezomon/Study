import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 3003
// Todo.  
// 조건 :  
/*
반례

*/
data class Node(var x: Int, var y: Int)

fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var s = br.readLine().split(" ")
  bw.write("${1-s[0].toInt()} ${1-s[1].toInt()} ${2-s[2].toInt()} ${2-s[3].toInt()} ${2-s[4].toInt()} ${8-s[5].toInt()}")
  //var n = br.readLine().toInt()
  //var answer = (a*l)-a+1
  /*
  var arr =  Array<Node?>(n){null}
  for(i in 0..n-1){ 
    arr[i] = Node(s[0].toInt(),s[1].toInt())
    //bw.write("$i\n")
  }
  arr.sortWith(compareBy({it?.x},{it?.y}))
 arr.forEach { bw.write("${it?.x} ${it?.y}\n")}
 */
  //bw.write(arr.joinToString())
  //bw.write("$count" + "\n")
  bw.flush()
  bw.close()
}