import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// import kotlin.math.*
// 1120
// Todo. // a랑 b 차이가 3일때  앞뒤뒤 앞앞뒤 앞뒤앞 3가지 경우 찾기 -> 숫자 2개로 3줄세우기
// -> 위에꺼아님.  앞 갯수 와 뒷 갯수 기준으로 생각하면됨. -->  숫자 2개 를 가지고 만든 합 == 문자열 a,b의 차이
// -> 이것을 최소로 하는것.
// 문자 길이차이가 n일때 숫자 2개로 합 n(문자열 a,b의차이) 만드는 모든 경우를 비교하기 (브루트포스)
// 응용버전) 숫자가 2개가 아닌 k개 라면 그 갯수만큼 for문이 중첩됨 --> 브루트포스로 안될듯 ->백트래킹..?
/*

*/
// data class Node(var y: Int, var x: Int, var visit: Boolean, var value: Int)
fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var n = br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack
  // var ss = br.readLine().split(' ')
  // var n = ss[0].toInt()
  // var s = ss[1].toInt() //합
  // var min = -1
  // var sums:Array<Int> = Array<Int>(n,{0})
  var ss = br.readLine().split(' ')
  var a = ss[0]
  var b = ss[1]
  var min = 51
  var n = b.length - a.length
  for (i in 0..n) {
    // bw.write("${i} ${n-i}\n")
    var d = 0
    for (j in i..(i + a.length - 1)) {
      // bw.write("${a[j-i]} ${b[j]}\n")
      if (a[j - i] != b[j]) {
        d++
      }
    }
    // bw.write("d${d}\n")
    if (min > d) {
      min = d
    }
  }
  /* var last = 0
  for (i in 0..a.length-1) {
    if(n-i<0){
      continue
    }
   // bw.write("${n-i} ${i}\n")
   bw.write("${a[i]} ${b[n-i]}\n")
    if(a[i]!=b[n-i]){
      last++
    }
  }
  bw.write("last${last}\n")*/
  bw.write("${min}")

  /*
  if(s[i] < min){
    minV = min(minV,s[i])
  }
  if(s[i] > max){
    maxV = max(maxV,s[i])
  }*/

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

  /*
    var answer : Int = 0
    for(i in 0..t-1){
      answer += s[i].digitToInt()
     //bw.write("${s[i].code}\n")
    }
  */

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
