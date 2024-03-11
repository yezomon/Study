import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
// 1181
//Todo. treeSet부분을 좀더 kotlin스럽게 바꾸는법
//Todo. sortWith랑 compareBy 사용법 좀더 공부, 중복제거하는 더 깔끔한 방법 
//Todo. 여러 조건으로 정렬하고 특정 조건(ex.중복을 단순히 제거하는 게 아니라 2개만 남기면서 출력한다던가 하는 응용) 적용하는법
//https://bcp0109.tistory.com/359
//https://incheol-jung.gitbook.io/docs/study/functional-programming-in-java-8/untitled-1
fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val n = br.readLine().toInt()
  var sr = Array<String>(n) {""}
  val treeSet = TreeSet<String>() 
  for(i in 0..n-1) {
    val input = br.readLine() // 줄바꿈 기준으로 넘어감 
    // sr[i] = input
    treeSet.add(input)
    //bw.write("$a\n")
  }
  var j = 0
  for(value in treeSet){
    sr[j] = value
    j++
      //println(value)
  }
  sr.sortWith(compareBy({it.length}, {it})) //sr.sort()
  sr.asSequence().filter{it->it!=""}.forEach { bw.write("$it\n")}
  
  //.filter{it->it!=null}
  //forEach(it->bw.write(it))
  //treeSet.sortWith(compareBy({it.length}, {it})) treeSet은 리스트처럼 순차접근 불가. iterator만 가능 
  //bw.write(sr.joinToString())
          /* for(i in 1..t) {
            val input = br.readLine() // 줄바꿈 기준으로 넘어감
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
