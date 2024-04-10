import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 2745
// Todo.  문자열로 들어오는 숫자를 실제 숫자로 변환시 toInt()가 아닌 code를 쓰는듯 
// 조건 : 결과는 10억이하 
//올림했기 때문에 사실 (x+a)/a = i인것인가?
/*
반례
10010 2
18
*/
//data class Node(var i: Int, var j: Int, var visit: Boolean, var value: Int)

fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var s = br.readLine().split(" ")
  //val a = s[0].toInt()
  var n = s[0]
  //bw.write("$n")
  var b = s[1].toInt()
  //bw.write("$b")
  //var answer = (a*l)-a+1
  //bw.write("$answer")
  var answer :Int = 0
  for(i in 0..n.length-1){
    var num: Int = 1
    if(n[i]>='A'){
      var d = n[i]-'A'
      num = 10+d
    }else {
      num = n[i].code - '0'.code
      //bw.write("$num\n")
    }
    //var answer = 1
    for (j in 1..n.length-1-i){
      num *= b 
    }
    answer += num
  }
  bw.write("$answer")
  
  //bw.write("$count" + "\n")
  bw.flush()
  bw.close()
  // var answer = av.toInt()
  // var sites = HashMap<String, String>() // Array<String>(n){""}
  // var passwords = Array<String>(m) {""}
  /*for (i in 0..n - 1) {
    var ss = br.readLine().split(" ")
    sites[ss[0]] = ss[1]
  }
  for (i in 1..m) {
    var site = br.readLine()
    if (sites.containsKey(site)) {
      bw.write(sites[site])
      bw.write("\n")
    }
  }*/
  // ar.sortDescending()
  // ar.forEach { bw.write("$it\n") }
  // bw.write(ar.joinToString())
  // var s = n.split(" ") // array
  // var len = s.size
  // var ar: List<String> = n.split(" ").filter { it!="" }
  // var len = ar.count()
  // bw.write("$len")
  // var sr = Array<String>(n) {""}
  // var ar: List<Int> = n.split("").filter { it!="" }.map{it.toInt()}
  // n.toCharArray().map{it.toInt()}.toTypedArray()
  // var  aw = ar.sorted().reversed()
  // aw.forEach{bw.write("$it")}
  // bw.write(aw.joinToString())
  // sr.sortWith(compareBy({it.length}, {it})) //sr.sort()
  // sr.asSequence().filter{it->it!=""}.forEach { bw.write("$it\n")}

  // treeSet.sortWith(compareBy({it.length}, {it})) treeSet은 리스트처럼 순차접근 불가. iterator만 가능
  // bw.write(sr.joinToString())
  /* for(i in 1..t) {
    val input = br.readLine().toInt() // 줄바꿈 기준으로 넘어감
    bw.write("\n")
    //val input = br.readLine() // 줄바꿈 기준으로 넘어감
    //val newTestString = input.split(" ")
    //var a = newTestString[0].toInt() +  newTestString[1].toInt()
    //bw.write("$a\n")
  }*/

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
/*
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val ref = Array(2000001) { false }
    val sb = StringBuilder()
    for (n in 1..readLine().toInt()) {
        ref[readLine().toInt() + 1000000] = true
    }
    for (n in 1000000 downTo -1000000) {
        if (ref[n + 1000000]) {
            sb.append(n)
            sb.append('\n')
        }
    }
    print(sb.toString())
}
*/
