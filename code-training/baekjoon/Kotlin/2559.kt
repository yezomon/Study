import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 2559
//
/*테케

*/
// data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
  var s = br.readLine().split(' ')
  var n = s[0].toInt()
  var k = s[1].toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack  ArrayList
  // var t = br.readLine().toInt() //0~1000사이의수
  var nums = br.readLine().split(' ')
  var arr = Array(n+3) { 0 } //1~n 
  arr[1] = nums[0].toInt()
  for (i in 1..n-1) {
    arr[i+1] = nums[i].toInt()+arr[i]
  }
  //bw.write("${arr.joinToString()}\n")
  var max = Integer.MIN_VALUE
  for(i in 1..n-k+1){
    if(max<arr[i-1+k]-arr[i-1]){
      max = arr[i-1+k]-arr[i-1]
    }
    //bw.write("${ arr[i-1+k]-arr[i-1]}\n")
  }
  bw.write("${max}")

  bw.flush()
  bw.close()
}

