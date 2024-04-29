import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedWriter
import java.util.*

//10989
// 
fun main() {
  //println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var arr:Array<Int> = Array<Int>(n,{0})
   var a = br.readLine().toLong()
   var b = br.readLine().toLong()
   var c = br.readLine().toLong()
   var answer : Long = a*b*c
   var s = answer.toString()
   
   val count0 = s.count{ it == 0.digitToChar() } //it == i.toChar()  // 0 
   bw.write("${count0}\n")
  for (i in 1..9){
    //var c = '1'+i
    var cc = i.digitToChar()//'0'.code + this
    //bw.write("${cc}\n")
    val count = s.count{ it == cc } //it == i.toChar()  // 0 
    bw.write("${count}")
    if (i!=9){
      bw.write("\n")
    }
  }
   //var words = HashMap<String,Int>() //k,v
   //words.containsKey('a')
   //var q :LinkedList<Int> = LinkedList<Int>()
  //var ts = TreeSet<Int>()
  //bw.write("${nf/kf}")

  bw.flush()
  bw.close()
}
