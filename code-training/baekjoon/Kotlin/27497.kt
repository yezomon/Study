import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// Think 문자열 시간초과 해결 
// 27497
// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val str = ArrayDeque<String>()  // 또는 mutableListOf<Int>() 사용 가능
  val stack = ArrayDeque<Int>()
  // val marked = mutableSetOf<Int>() // 빈 집합으로 시작
  var n = br.readLine().toInt()
  // var array = Array(nm[0].toInt()) { Array(nm[1].toInt()){""}}
  //var sb = StringBuilder() //시간초과
  for (i in 1..n) {
    var text = br.readLine().split(' ')
    var cmd = text[0].toInt() 
    when {
      cmd == 1 -> {
        stack.add(1)
        str.addLast(text[1])//sb.append(text[1])
      }
      cmd == 2 -> {
        stack.add(2)
        str.addFirst(text[1])//sb.insert(0, text[1])
      }
      cmd == 3 && str.size > 0 -> {
        var sr = stack.removeLast()
        if (sr == 1) { // 맨뒤
          str.removeLast()//sb.deleteAt(sb.length - 1)
        } else if (sr == 2) { // 맨앞
          str.removeFirst()//sb.deleteAt(0)
        }
      }
    }
    // bw.write(sb.toString()+"\n")
  }
  if (str.size > 0) bw.write(str.joinToString("")) else bw.write("0") 

  bw.flush()
  bw.close()
}
