import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 15649
// Todo. https://blog.encrypted.gg/732
// https://blog.encrypted.gg/945
// 조건 :
/*
반례

*/
// data class Node(var x: Int, var y: Int)
val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()

  var s = br.readLine().split(" ")
  // bw.write("${1-s[0].toInt()} ${1-s[1].toInt()} ${2-s[2].toInt()} ${2-s[3].toInt()}
  // ${2-s[4].toInt()} ${8-s[5].toInt()}")
  // var n = br.readLine().toInt()
  var n = s[0].toInt()
  var m = s[1].toInt()
  var isUsedArr = Array<Boolean>(10) { false } // 해당 숫자 사용여부
  var arr = Array<Int>(10) { 0 } // 수열
  BackTracking(0,m,n,isUsedArr,arr)
  // bw.write("${n2+diff}")
  // var answer = (a*l)-a+1
  /*
   var arr =  Array<Node?>(n){null}
   for(i in 0..n-1){
     arr[i] = Node(s[0].toInt(),s[1].toInt())
     //bw.write("$i\n")
   }
   arr.sortWith(compareBy({it?.x},{it?.y}))
  arr.forEach { bw.write("${it?.x} ${it?.y}\n")}
  */
  // bw.write(arr.joinToString())
  // bw.write("$count" + "\n")
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

fun BackTracking(k: Int, m: Int, n: Int, isUsedArr:Array<Boolean>, arr:Array<Int>) {
  if (k == m) { // m개 수 선택
    for (i in 0..m-1) {
      bw.write("${arr[i]}")
      bw.write(" ")
    }
    bw.write("\n")
    return
  }
  
  for(i in 1..n){ //왜 1부터 시작인것..? 
    if(isUsedArr[i]==false){
      arr[k] = i
      isUsedArr[i] = true
      BackTracking(k+1,m,n,isUsedArr,arr)
      isUsedArr[i] = false
    }  
  }
}