import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 2798
// Todo. 재귀로 푸는건어떨지 . (현재 완전탐색으로 품 )
// data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
  var s = br.readLine().split(' ')
  var n = s[0].toInt()
  var m = s[1].toInt()
  var ts = TreeSet<Int>()
  var ss = br.readLine().split(' ')
  // 5*4*3 = 60
  for (i in 0..n - 1) {
    var sum :Int
    for (j in 0..n - 1) {
      if (i == j) {
        continue
      }
      for (k in 0..n - 1) {
        if (j == k) {
          continue
        }
        if (i == k) {
          continue
        }
        sum = ss[i].toInt() + ss[j].toInt() + ss[k].toInt()
        if(sum<=m){
          ts.add(sum)
          // bw.write("${sum} ")
        }
      }
    }
  }
  //bw.write("v:${ts.joinToString()}\n")
  var arr = ts.toList()
  var answer = 0
  for (i in 0..arr.size - 1) {
    if(arr[i]<=m){
      if(answer <= arr[i]){
        answer = arr[i]
      }
    }
    //bw.write("${arr[i]}\n")
  }
  bw.write("${answer}")

  bw.flush()
  bw.close()
}