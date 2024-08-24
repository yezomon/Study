import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// Todo. sortWith, sort, reverse, sortDescending, SortBy
/*학생들의 목적지를 1번, 3번, 5번 교실로 정한다.
1번 교실의 방문 횟수는 3이고 교실의 점수는 3 × 3 = 9가 된다.
2번 교실의 방문 횟수는 2이고 교실의 점수는 -5 × 2 = -10가 된다.
3번 교실의 점수는 2 × 2 = 4이다.
4번 교실의 점수는 -1 × 1 = -1이다.
5번 교실의 점수는 4 × 1 = 4다.
https://sey2.github.io/posts/Java-IllegalArgumentException/
*/
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val nk = br.readLine().split(' ').map { it.toInt() } // nk
  val ai = br.readLine().split(' ').map { it.toLong() }.toMutableList()
  var arr = ArrayList<Pair<Int,Long>>(nk[0]) //MutableList<Int>(nk[0]) { 0 }
  //arr.addAll(ai)
  for(i in 0..nk[0]-1){
    arr.add(Pair(i,ai[i]))
  }
  for(i in 1..nk[0]-1){
    arr[i] = Pair(arr[i].first, arr[i].second + arr[i - 1].second)
  }
  arr.sortWith{a,b->b.second.compareTo(a.second)}
  //ai.sortWith{a,b->b.compareTo(a)} //{a,b->b-a} illegal exception
  //var result = ai.take(nk[0]).sumOf { it }//ai.take(nk[1]).sumOf { it }
  // var p = s.toMutableList().sortedDescending().take(t[1]).toTypedArray().sumOf { it }
  var sub = arr.take(nk[0]).subList(0,nk[1])
  var ssub = sub.sortedWith{ a, b -> a.first.compareTo(b.first) }
  //bw.write("${arr}\n")
  //bw.write("${ssub}\n")
  //bw.write("${ai}\n")
  var result = 0L
  var count = nk[1]
  var j = 0
  for(i in 0..nk[0]-1){
    //bw.write("ai ${ai[i] * count}\n")
    result += ai[i] * count
    if(j<ssub.size && i==ssub[j].first){
      j++
      count--
    }
  }
  bw.write("${result}")
  bw.flush()
  bw.close()
}

// tailrec fun factorial(n: Int, result: Long = 1): Long {
//     if (n == 1) return result
//     return factorial(n - 1, n * result)
// }
// fun findM() : Boolean{
// }
