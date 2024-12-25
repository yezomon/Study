import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// with claude. 재귀 구현 
// 2303
/*
3
7 5 5 4 9
1 1 1 1 1
2 3 3 2 10

*/
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt() //.split(" ").map { it.toInt() } //t x m 
  //var m = TreeMap<Int, Int>()
  var result = -1
  var resultP = 0
  for (i in 1..n) {
    // m.put(s[0], s[1]) // 효능, 이름
    var s = br.readLine().split(" ").map{it.toInt()}
    var ss = s.toIntArray() 
    for(j in 1..5){
      //val arr = intArrayOf(1, 2, 3, 4, 5)  // 5개의 숫자
      val visited = BooleanArray(5) { false }  // 방문 체크 배열

      var c = combination(ss, visited, 0, 5, 3)  // 5개 중 3개 선택
      if(c%10 >= result){
        //bw.write("$c\n")
        resultP = i
        result = c%10
      }
    }
    // arr[i] = s.toCharArray().map { it.toString() }.toTypedArray()
  }
  bw.write("$resultP")
  // bw.write(m.toList().joinToString() + "\n")
  // val result = arr3.flatten().count { it == 1 }

  bw.flush()
  bw.close()
}

fun combination(arr: IntArray, visited: BooleanArray, start: Int, n: Int, r: Int) : Int{
    if(r == 0) {
       var sum = 0
        for(i in 0 until n) {
            if(visited[i]) {
                //print("${arr[i]} ")
                sum += arr[i] 
            }
        }
        //println()
        return sum
    }

var maxSum = 0  // 최대값을 저장할 변수
for(i in start until n) {
    visited[i] = true
    val currentSum = combination(arr, visited, i + 1, n, r - 1)
    maxSum = maxOf(maxSum%10, currentSum%10)  // 최대값 갱신
    visited[i] = false
}
return maxSum  // for 루프 밖에서도 return 필요
}
