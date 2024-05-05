import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// import kotlin.math.*
fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))

  var answer: Int = 0
  var s = br.readLine().toInt()
  var count = 0
  while (true) {
    answer++
    if (answer.toString().contains("666")) {
      count++
      //bw.write("${answer}")
    }
    if(count==s){
      bw.write("${answer}")
      break
    }
    // bw.write("${arr.joinToString()}\n")
  }
  bw.flush()
  bw.close()
}
