import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 10845
/* Queue
명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front

1
2
2
0
1
2
-1
0
1
-1
0
3
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  //val str = ArrayDeque<String>()  // 또는 mutableListOf<Int>() 사용 가능
  val q = LinkedList<Int>()
  // val marked = mutableSetOf<Int>() // 빈 집합으로 시작
  var n = br.readLine().toInt()
  // var array = Array(nm[0].toInt()) { Array(nm[1].toInt()){""}}
  //var sb = StringBuilder() //시간초과 
  // var ix = if (s.indexOf("0")>s.indexOf("1")) s.indexOf("0") else s.indexOf("1")
  // var num = s[ix].code -'0'.code
  for (i in 1..n) {
    var text = br.readLine().split(' ')
    
    var cmd = text[0]
    when {
      "push".equals(cmd) -> {
        q.add(text[1].toInt())
        continue
        //str.addLast(text[1])//sb.append(text[1])
      }
      "pop".equals(cmd) -> {
        var e = q.poll()  //pop 하니까 NoSuchElement Exception! 
        if(e==null) bw.write("-1") else bw.write("$e")
        //str.addFirst(text[1])//sb.insert(0, text[1])
      }
      "size".equals(cmd) -> {
        bw.write("${q.size}") //q.add(text[1].toInt())
      }
      "empty".equals(cmd) -> {
        if(q.isEmpty()) bw.write("1") else bw.write("0") //q.add(text[1].toInt())
      }
      "front".equals(cmd) -> {
        var e = q.peek()
        if(e==null) bw.write("-1") else bw.write("$e")
      }
      "back".equals(cmd) -> {
        var e = q.peekLast()
        if(e==null) bw.write("-1") else bw.write("$e")
      }
    }
    if(i<n) bw.write("\n")
    // bw.write(sb.toString()+"\n")
  }
  bw.flush()
  bw.close()
}
