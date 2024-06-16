import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 2170
/*
3
1 4
2 3
2 6
기대값 : 5 결과값: 6
입력 :
2
1 2
2 3
정답  :2
1
-1 1
expect : 2
output : 0
3
1 6
2 3
4 5
정답 : 5
오답 : 3
*/
// Todo. 선긋기 - 스위핑알고리즘 
data class Node(var start: Long, var end: Long)
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
  var n = br.readLine().toInt()
  var arr = Array<Node>(n){Node(0,0)}
  for(i in 0..n-1){
    var s = br.readLine().split(' ')
    arr[i] = Node( s[0].toLong(),s[1].toLong())
  }
  arr.sortWith(compareBy({it.start})) //(compareBy({it.start},{it.end})) 정렬기준갯수만큼 시간복잡도.,기준 빼니까 시간초과 안남. 
  //bw.write("v:${arr.joinToString()}\n")
  var begin =arr[0].start
  var end = arr[0].end
  var answer : Long = 0
  for(i in 1..n-1){
    // if (arr[i].start<=end) {  //  r = max(r, L[i].second);
    //   end = arr[i].end
    // }
    if(arr[i].start>end){ //초기화 
      answer += end-begin
      begin = arr[i].start
      end = arr[i].end
      
    }else if(arr[i].end>end){ //if (arr[i].start<=end) {
      end = arr[i].end
    }
   // bw.write("a${begin} ${end}\n")
  }
  answer += (end-begin)
  bw.write("${answer}")
  bw.flush()
  bw.close()
}