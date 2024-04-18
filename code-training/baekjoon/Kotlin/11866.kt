import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedWriter
import java.util.Queue;
import java.util.LinkedList;

//11866
// N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
/*
N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거
7 3
<3, 6, 2, 7, 5, 1, 4>
1234567
*/
fun main() {
  //println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))

  // var arr:Array<Int> = Array<Int>(n,{0})
   var s = br.readLine().split(" ")
   var n=s[0].toInt()
   var k=s[1].toInt()
   var q :Queue<Int> = LinkedList<Int>()
   for(i in 1..n){
     q.add(i)
   }
   //bw.write(q.joinToString())
   //bw.write("\n")
  //var ts = TreeSet<Int>()
  // var max: Int = -1
  var count = 1
  bw.write("<")
  while(q.size > 0){
    var e = q.remove()
    if(count%k==0){ //이것이 반례가 된다 https://www.acmicpc.net/board/view/136365
      //bw.write(q.joinToString())
      //bw.write("queue! \n")
      bw.write("${e}")
      if(q.size>0){
          bw.write(", ")
      }
    }else{
      q.add(e)
      //bw.write(q.joinToString())
      //bw.write("queue~ \n")
    }
    count++
    
  }
  bw.write(">")
    //ts.add(mod)
    //bw.write("${s[0]} ${s[1]}\n")
   //bw.write(ts.joinToString()+"\n")
   //bw.write("${ts.size}")
  //bw.write("$max\n")
  bw.flush()
  bw.close()
}
