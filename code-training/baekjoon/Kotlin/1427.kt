import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
// 1427
//Todo. Array자료구조는 filter가 안되는건가?알아보기 / 단순 reversed는 리스트를 그냥 뒤집음.
fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val n = br.readLine()
  //var sr = Array<String>(n) {""}
  var ar: List<Int> = n.split("").filter { it!="" }.map{it.toInt()}
  //n.toCharArray().map{it.toInt()}.toTypedArray()
  var  aw = ar.sorted().reversed()
  aw.forEach{bw.write("$it")}
  //bw.write(aw.joinToString())
 // sr.sortWith(compareBy({it.length}, {it})) //sr.sort()
  //sr.asSequence().filter{it->it!=""}.forEach { bw.write("$it\n")}
  
  //.filter{it->it!=null}
  //forEach(it->bw.write(it))
  //treeSet.sortWith(compareBy({it.length}, {it})) treeSet은 리스트처럼 순차접근 불가. iterator만 가능 
  //bw.write(sr.joinToString())
          /* for(i in 1..t) {
            val input = br.readLine().toInt() // 줄바꿈 기준으로 넘어감
            val newTestString = input.split(" ")
            bw.write("\n")
            //val input = br.readLine() // 줄바꿈 기준으로 넘어감
            //val newTestString = input.split(" ")
            //var a = newTestString[0].toInt() +  newTestString[1].toInt()
            //bw.write("$a\n")
          }*/
          bw.flush()
  bw.close()
  // 공백(띄어쓰기) 기준으로 잘라줌
  // val newTestString = input.split(" ")
  // println(newTestString)
  // println(newTestString[0])
  // println(newTestString[1])
  // val input = br.readLine()
  // var t = input.toInt()
  // var a = 0
  // for (i in 1..t) {
  //   var s = i.toString()
  //   for (j in 0..s.length-1){
  //     if (s[j] == '1'){
  //       a++
  //     }
  //   }

  // }
  // bw.write("$a\n")
  // println("$input " + input?.length)
  // bw.write("$input\n"+ input?.length+" \n")

}
