import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 6321
// Todo.  
// 조건 : 알파벳 Z의 다음 순서는 A

fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  //var s = br.readLine().split(" ")
  //val a = s[0].toInt()
  var n = br.readLine().toInt()
  for(i in 1..n){
    var s = br.readLine()
    bw.write("String #"+"$i"+"\n")
    for(j in 0..s.length-1){
      var c:Char = s[j].toChar()
      if (c=='Z'){
        c='A'
      }else{
        c++
      }
      bw.write("$c")
    }
    if (i!=n){
      bw.write("\n")
      bw.write("\n")
    }
  }
  //bw.write("$count" + "\n")
  bw.flush()
  bw.close()
}
