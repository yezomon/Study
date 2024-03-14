import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 17219
// Todo.
fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var s = br.readLine().split(" ")
  val n = s[0].toInt()
  var m = s[1].toInt()
  var sites = HashMap<String, String>() // Array<String>(n){""}
  // var passwords = Array<String>(m) {""}
  for (i in 0..n - 1) {
    var ss = br.readLine().split(" ")
    sites[ss[0]] = ss[1]
  }
  for (i in 1..m) {
    var site = br.readLine()
    if (sites.containsKey(site)) {
      bw.write(sites[site])
      bw.write("\n")
    }
  }
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
  bw.flush()
  bw.close()
  // bw.write("$a\n")
  // println("$input " + input?.length)
  // bw.write("$input\n"+ input?.length+" \n")

}
