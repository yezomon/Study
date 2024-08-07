import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

// Todo.
// 12034
// 그는 25% 할인된 가격으로 상점의 모든 품목을 판매하기로 결정했습니다. 즉, 각 품목의 판매 가격은 정상 가격의 정확히 75 %입니다. 우연하게도 인천 식료품가게에서 판매하는 모든 물건의 정상가는 4의 배수인 정수이고, 할인된 가격 역시 편리하게도 모두 정수입니다.
// 할인 가격출력. 
// 100 -> 75 
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()
  // var h = Regex(Regex.escape(":-)")).findAll(n).count() //contains("1")
  // var uh = Regex(Regex.escape(":-(")).findAll(n).count()
  val t = br.readLine().toInt() //.split(' ').map{it.toInt()} // n, t
  //var arr = Array(s[0].toInt()+2) { 0.toLong() } //LinkedList<ab>() //List(n[0]) { 0 }//Array(n[0]) { 0 } 이것은 뮤터블인가 아닌
  //var arr = Array(15) { Array(15) { 0 } }
  //72 - 15 1/1/1
  for(c in 1..t){
    var n = br.readLine().toInt()
    var s = br.readLine().split(' ').map{it.toLong()}.toMutableList() //.map{it.toInt()} r,c
    for(i in 0..s.size-1){
      var r = s[i].toLong()*100/75
      for(j in 0..s.size-1){
        if(s[j] == r){
         s[j] = -1 // s.removeAt(j) //s[j] = -1
          break
        }
      }
      //bw.write("${s[i].toInt()*100/75} ")
    }
    bw.write("Case #${c}: ${s.filter { it > 0 }.joinToString(" ")}\n")
    //var arr : Array<Int>//Array(s[0].toInt()){Array(s[1].toInt()) { -1 }}
  }
  //bw.write("${arr.joinToString()}\n")
  bw.flush()
  bw.close()
}

// tailrec fun factorial(n: Int, result: Long = 1): Long {
//     if (n == 1) return result
//     return factorial(n - 1, n * result)
// }
// fun findM() : Boolean{
// }
