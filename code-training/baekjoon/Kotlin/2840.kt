import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 2840
// https://alpharodun.tistory.com/42
// 반례
/*
# input
4 4
1 A
1 A
1 A
1 A

# output
AAAA <-- wrong. ?가 나와야 정답

*/
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))

  // Initialize the pair list
  // val pairList = mutableListOf<Pair<Int, Int>>()
  val (n, k) = readLine()!!.split(" ").map { it.toInt() }
  var wheel = Array(n) { "?" } // { readLine()!! }
  var startIdx = n - 1
  var result = ""

  for (i in 0 until k) {
    var s2 = br.readLine().split(" ")
    var d = s2[0].toInt()
    var c = s2[1].toString()
    d = if (d >= n) d % n else d
    startIdx = startIdx - d
    startIdx = if (startIdx < 0) startIdx + n else startIdx
    if (!wheel[startIdx].equals("?") && !wheel[startIdx].equals(c)) {
      result = "!" // bw.write("!")
      break
    }
    wheel[startIdx] = c
    //bw.write("${startIdx}\n")
  }

  for (i in 0 until n) {
    if (result.equals("!")) {
      break
    }
    
    result += if (startIdx + i < n) wheel[startIdx + i] else wheel[startIdx + i - n]
  }
  // bw.write("${wheel.joinToString(" ")}\n")
  if( result.filter { it != '?' }
    .groupingBy { it }
    .eachCount()
    .any { it.value > 1 }){ //if(result.groupingBy { it }.eachCount().any { it.value > 1 }){
    result = "!"
  }
  bw.write("${result}")

  // var r = if (n > m) m else n
  // val n = br.readLine().toDouble()//.split(' ')
  // val m = br.readLine().toDouble() 반지름.
  // var h = Regex(Regex.escape(":-)")).findAll(n).count() //contains("1")
  // var uh = Regex(Regex.escape(":-(")).findAll(n).count()
  // val result = when {
  //     h>uh -> "happy"
  //     h<uh -> "sad"
  //     h>0&&h==uh&&uh>0 -> "unsure"
  //     else -> "none"
  // }
  // bw.write("${h} ${uh}")
  // var result = n*2.0 + 2 * m * 3.141592
  // result = 2 * d1.toDouble() + 2 * d2.toDouble() * Math.PI
  // n*2 + (m/2)*(m/2)*3.141592
  // val formatter = DecimalFormat("#0.0")
  // val formattedNumber = formatter.format(result/2)
  // bw.write("${result}")
  bw.flush()
  bw.close()
}