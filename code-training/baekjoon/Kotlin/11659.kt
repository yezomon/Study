import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// import kotlin.math.*
// 11659
// 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
//N과 M 1 ≤ N ≤ 100,000 1 ≤ M ≤ 100,000

fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))

  var s = br.readLine().split(' ')
  var n = s[0].toInt()
  var m = s[1].toInt()
  var nums = br.readLine().split(' ')
  var sums:Array<Int> = Array<Int>(n,{0})
  sums[0] = nums[0].toInt()
  var v = 0//sums[0]
  for(x in 0..n-1){
    v += nums[x].toInt()
    sums[x] = v
  }
 // bw.write("${sums.joinToString()}\n")
  //5 4 3 2 1
  //5,9,12,14,15
  for(k in 0..m-1){
    var r = br.readLine().split(' ')
    var i = r[0].toInt()
    var j = r[1].toInt()
    if(i-2<0){
      bw.write("${sums[j-1]}\n")
      continue
    }
    var answer = sums[j-1] - sums[i-2]
    //2,4(= 0,3)  = 1~4 - 1~1
    //i부터 j 합(i-1 ~ j-1) =  j-1~0의 합 - 0~i-2까지 합 
    bw.write("${answer}\n")
  }
  /* 시간 초과 
  for(k in 0..m-1){
    var r = br.readLine().split(' ')
    var i = r[0].toInt()
    var j = r[1].toInt()
    var answer = 0
    for(x in i-1..j-1){
      answer += nums[x].toInt()
    }
    bw.write("${answer}\n")
  }*/
  
  bw.flush()
  bw.close()
}
