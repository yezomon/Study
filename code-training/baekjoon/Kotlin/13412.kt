import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

// Todo. 2가지 최적화 이유 찾기(약수의대칭성, gcd)  & 공부하기 
// 13412 n을 최소공배수로 하는 서로소  쌍 (서로소는 최대공약수가 1뿐이다.)
// data class ab (var a:Int, var b:Int, var c:Int)
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()
  // var h = Regex(Regex.escape(":-)")).findAll(n).count() //contains("1")
  // var uh = Regex(Regex.escape(":-(")).findAll(n).count()
  val n = br.readLine().toInt() // .split(' ').map{it.toInt()} // n, t
  // var arr = Array(s[0].toInt()+2) { 0.toLong() } //LinkedList<ab>() //List(n[0]) { 0
  // }//Array(n[0]) { 0 } 이것은 뮤터블인가 아닌
  repeat(n) {
    var p = br.readLine().toInt()
    var result = 0
    for (i in 1..sqrt(p.toDouble()).toInt()) { // 약수의 대칭성 이용
      when {
        p % i == 0 && gcd(i, p / i) == 1 -> result++
      }
    }
    bw.write("${result}\n")
  }
  // bw.write("${arr.joinToString()}\n")
  bw.flush()
  bw.close()
}
// 최대공약수
fun gcd(a: Int, b: Int): Int {
  var x = a
  var y = b
  while (y != 0) {
    val temp = y
    y = x % y
    x = temp
  }
  return x
  // 시간초과 나서 위와 같이 최적화하라고 알려줬는데 왜 저게 가능한거지??
  // var r = 0
  // var i = 1
  // while(i<=a && i<= b){
  //   if(a%i == 0 && b%i==0){
  //     r = i
  //   }
  //   i++
  // }
  // return r
}
