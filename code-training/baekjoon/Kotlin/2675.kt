import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedWriter
import java.util.Queue;
import java.util.LinkedList;

//2675
// N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
//Todo. 3중 포문이 발생하는데 이것을 좀더 Kotlin 스럽게 함수형으로 바꿀필요가 매우매우있음 
/*
2
3 ABC
5 /HTP
*/
fun main() {
  //println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var arr:Array<Int> = Array<Int>(n,{0})
   var t = br.readLine().toInt() //.split(" ")
   //var q :Queue<Int> = LinkedList<Int>()
   for(i in 1..t){
     var ss = br.readLine().split(" ")
     var r = ss[0].toInt()
     var s = ss[1]
    for (k in 0..s.length-1) {
      for(j in 1..r){
          bw.write("${s[k]}")
        }
    }
    if(i!=t){
      bw.write("\n")
    }
   }
   //bw.write(q.joinToString())
  //var ts = TreeSet<Int>()
  // var max: Int = -1
    //ts.add(mod)
    //bw.write("${s[0]} ${s[1]}\n")
   //bw.write(ts.joinToString()+"\n")
   //bw.write("${ts.size}")
  //bw.write("$max\n")
  bw.flush()
  bw.close()
}
