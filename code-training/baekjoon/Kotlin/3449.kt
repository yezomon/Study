import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.*
//3449
fun main() {
  //val (n, m) = readLine()!!.split(" ").map { it.toInt() }
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt()//readLine().toInt()
  //val (n, m) = readLine()!!.split(" ").map { it.toInt() }
  var s1 = Array(n * 2) {br.readLine()}//{ readLine()!! }
  for(i in 0 until n){
    var s = s1[i*2]
    var s2 = s1[i*2+1]
    var count = 0
    for(j in 0 until s.length){
      if(s[j]!=s2[j]){count++}
    }
    bw.write("Hamming distance is ${count}.\n");
  }
  bw.flush()
  bw.close()
  
}
