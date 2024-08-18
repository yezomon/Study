import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
//Todo. 코드 리팩토링
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val s = br.readLine().split(' ')//.map{it.toInt()} // n, t
  var arr = Array(s[0].toInt()+2) { 0.toLong() } //LinkedList<ab>() //List(n[0]) { 0 }//Array(n[0]) { 0 } 이것은 뮤터블인가 아닌가 
  arr[0] = 0
  arr[arr.size-1] = s[1].toLong()
  var r = listOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1)) //{{1,0}, {0,-1}, {-1,0}, {0,1}}
  //var l = listOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1)) //{{1,0}, {0,1}, {-1,0}, {0,-1}}
  //각 회전 후 이동한 양에 대한 결과는 그다음번 입력(남은시간)에 의해 결정된다. 
  //시작 0,0->   "30,0 r-> 0,-20 r-> -10,0 l"->  0,-40 -> 종료 결과 20,-60
  var ri = 0 
  var ai = 1
  var x : Long
  var y : Long
  var resultX :Long = 0
  var resultY :Long= 0
  repeat(s[0].toInt()){
      var p = br.readLine().split(' ')
      arr[ai] = p[0].toLong()
      x = r[ri].first*(p[0].toLong()-arr[ai-1])
      y = r[ri].second*(p[0].toLong()-arr[ai-1])
      //bw.write("${x} ${y}\n")
      resultX += x
      resultY += y 
      when{
        p[1].equals("right") -> ri++
        p[1].equals("left") -> ri--
      }
      ri = when{
        ri<0 -> r.size-1
        ri>r.size-1 -> 0
        else -> ri
      }
      ai++
  }
  x = r[ri].first*(s[1].toLong()-arr[ai-1])
  y = r[ri].second*(s[1].toLong()-arr[ai-1])
  //bw.write("${x} ${y}\n")
  resultX += x
  resultY += y
  bw.write("${resultX} ${resultY}")
  //bw.write("${arr.joinToString()}\n")
  bw.flush()
  bw.close()
}
