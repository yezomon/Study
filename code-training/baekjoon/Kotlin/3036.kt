import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
   val n = br.readLine().toInt()
   var c = br.readLine().split(' ').map { it.toInt() }
   for(i in 1..n-1){
     var gcd = g(c[0],c[i])
     if(c[0]%c[i]==0) bw.write("${c[0]/c[i]}/1\n")
     else bw.write("${c[0]/gcd}/${c[i]/gcd}\n")
   }
  bw.flush()
  bw.close()
}

fun g(a: Int, b: Int): Int {
  var x = a
  var y = b
  while (y != 0) {
    val temp = y
    y = x % y
    x = temp
  }
  return x
}
