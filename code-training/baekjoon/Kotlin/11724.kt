import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 11724
// 조건 : 첫째 줄에 정점의 개수 N과 간선의 개수 M (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v (1 ≤
// u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
// Todo.이를 통해 문제에서 말하는 연결 요소라는 것은 그래프의 개수 또는 영역의 개수로 이해하면 된다.
// 반례 : 단방향으로만 저장하니까 카운트가 2로 찍힘 노드1일때 한번, 노드2일때 한번
/*
2 1
2 1
답: 1 
*/
data class Node(var linkArr: Array<Boolean>, var visit: Boolean, var value: Int)

fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  val s = br.readLine().split(" ")
  val n = s[0].toInt()
  val m = s[1].toInt()

  var q: Queue<Node> = LinkedList<Node>()
  // var arr:Array<Boolean> = Array(n,{false}) //Array<Array<Int>> = Array(n){Array(n){0}}
  // //Array(n, { 0 })
  var answer:Int = 0
  var arr: Array<Node?> = Array(n, { null })
  for (i in 0..n - 1) {
    arr[i] = Node(Array(n, { false }), false, i + 1)
  }
  for (i in 1..m) {
    val l = br.readLine().split(" ")
    val u = l[0].toInt()
    val v = l[1].toInt()
    arr[u - 1]!!.linkArr[v - 1] = true
    arr[v - 1]!!.linkArr[u - 1] = true
  }
  //bw.write("arr:" + arr.joinToString() + "\n")
  for (i in 0..n-1) {
    if(arr[i]?.visit==true){
      continue
    }
    q.add(arr[i])
    while (q.size > 0) {
      //bw.write("queue:" + q.joinToString() + "\n") // + "$e.value"
      var e = q.remove()
      e?.visit = true
      for (j in 0..n - 1) {
        if (e!!.linkArr[j] == true && arr[j]?.visit == false) { // 해당 노드끼리 연결된 상태임&미방문
          arr[j]?.visit = true
          q.add(arr[j])
        }
      }
    }
    //bw.write("exit queue:" + q.joinToString() + "\n")
    answer++
    // q.add()
    // val input = br.readLine() // 줄바꿈 기준으로 넘어감
    // bw.write("$a\n")
  }
  bw.write("$answer")
  bw.flush()
  bw.close()
}
