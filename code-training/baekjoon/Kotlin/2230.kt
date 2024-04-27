import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

// 2230
// N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다), 그 차이가 M 이상이면서 제일 작은 경우를
// 구하는 프로그램
// 1 ≤ N ≤ 100,000
// 0 ≤ M ≤ 2,000,000,000 20억
// 0 ≤ |A[i]| ≤ 1,000,000,000 10억
// Todo. 투포인터 https://blog.encrypted.gg/1004
/*
3 3
1
5
3
*/
// data class Node(var y: Int, var x: Int, var visit: Boolean, var value: Int)
fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var n = br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack
  var ss = br.readLine().split(' ')
  var n = ss[0].toInt()
  var m = ss[1].toInt()
  var answer = Integer.MAX_VALUE // p1(start포인터)과 p2(end포인터)차이  
  var arr: Array<Int> = Array<Int>(n, { 0 })
  for (i in 0..n - 1) {
    arr[i] = br.readLine().toInt()
  }
  arr.sort() //오름차순정렬 
  //bw.write(arr.joinToString())
  var p2 = 0
  for (p1 in 0..n - 1) {
    while (p2 < n && (arr[p2] - arr[p1]) < m) { //m조건이 충족안됐으므로 end포인터를 옮김, 최소값을 찾아야하기때문에 현재 스타트포인터 상태에서 최초로 m조건 충족하면 현재 p1가 포함되는 수열에서 찾을수있는 최소값임.(->오름차순 정렬된 수열이기때문) 그러므로 while중단하고 p1을증가시키면서 다음으로 넘어감. 
      p2++
    }
    if (p2 == n) { 
      break
    }
    answer = min(answer, arr[p2] - arr[p1]) //m조건이 충족된 값과 현재미니멈값 비교 
  }
  bw.write("${answer}")
  /*for(i in 0..n-2){
    sums[i+1] = sums[i] + nums[i+1].toInt()
  }*/
  // bw.write(sums.joinToString())

  /*
  if( answer == Integer.MAX_VALUE){
    bw.write("${-1}")
  }else{
    bw.write("${answer}")
  }
  for(i in 0..n-1){ //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임)
    //answer += k/arr[n-1-i]
    //k%=arr[n-1-i]
    //bw.write("${arr[i]}\n")
  }*/

  /*var s = br.readLine()
  var answer : Int = 0
  for(i in 0..t-1){
    answer += s[i].digitToInt()
   //bw.write("${s[i].code}\n")
  }
  bw.write("${answer}")*/

  // var arr: Array<Int> = Array<Int>(10001, { 0 })
  /*var dir =
  arrayOf(
      arrayOf(0, 1),
      arrayOf(1, 0),
      arrayOf(-1, 0),
      arrayOf(0, -1)
  )*/
  // var dir:Array<Array<Int>> = Array(4){Array(2){0}}

  // bw.write(numList.joinToString())
  // var words = HashMap<String,Int>() //k,v
  // words.containsKey('a')
  // var q :LinkedList<Int> = LinkedList<Int>()
  // var ts = TreeSet<Int>()
  // bw.write("${nf/kf}")

  bw.flush()
  bw.close()
}
