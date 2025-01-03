import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 1235

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var n = br.readLine().toInt()
  var list = LinkedList<String>()
  repeat(n) {
    var s = br.readLine()
    list.add(s)
  }
  var arr = list.toTypedArray()
  var nn = arr[0].length - 1
  // 각 substring 길이별 map ?
  val maplist = Array(nn + 1) { mutableMapOf<String, Int>() } // substr, level
  var result = nn+1
  for (i in 0..nn) { //level 
    maplist[i] = mutableMapOf()
    for (j in 0..n - 1) { // str 갯수 
      // bw.write(arr[i].takeLast(j + 1) + "\n")
      if (maplist[i].containsKey(arr[j].takeLast(i + 1))) {
        result = nn+1
        break 
      }else {
        result = min(i+1,result)
        maplist[i].put(arr[j].takeLast(i + 1), i) 
      }
    }
    // bw.write(arr[i]+"\n") //
  }
  bw.write("$result")

  bw.flush()
  bw.close()
}
