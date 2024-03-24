import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// 1926
// 6321
// Todo.  BFS 너비우선탐색의 시간복잡도? 왜 이문제가 깊이 우선탐색이 아닌 너비우선인지? 차이가 뭔지?
// 조건 :그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력
//  가로나 세로로 연결된 것은 연결이 된 것
// 연결된 모든 부분이 하나의 그림
// 크기 최대 500 * 500 = 250000
/*
반례
입력값
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1

출력값
4
9

기대값
4
9

*/
data class Node(var i: Int, var j: Int, var visit: Boolean, var value: Int)

fun main() {
  // println("Hello world!")
  // var a: Int = readLine()!!.toInt()
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var s = br.readLine().split(" ")
  val n = s[0].toInt()
  val m = s[1].toInt()
  var count = 0 // 각 그림의 넓이
  var maxArea = 0 // 그림넓이max

  val drawArray: Array<Array<Node?>> =
      Array(n) { Array(m) { null } } // {IntArray(m)}) //int[][] data = new int[size][size];
  var queue: Queue<Node> = LinkedList<Node>()

  for (i in 0..n - 1) {
    var d = br.readLine().split(" ")
    for (j in 0..m - 1) {
      var v = d[j].toInt()
      drawArray[i][j] = Node(i, j, false, v) // d[j].toInt()
    }
  }
  // var p: Node? = drawArray[0][0] // Node(0, 0, false,d[j].toInt())
  // queue.add(drawArray[0][0])
  // val dir = Array(4) { Array(2){} } //{1,0},{0,1},{-1,0},{0,-1}
  var dir = arrayOf(arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(0, -1))
  // var d1: Int = dir[1][0]
  // var d2: Int = dir[1][1]
  // bw.write("dir:" + "$d1" + "/" + "$d2" + "\n")
  var numOfDrawing = 0
  // BFS
  for (k in 0..n - 1) {
    for (j in 0..m - 1) {
      if (drawArray[k][j]?.visit == true) {
        continue
      }
      if (drawArray[k][j]?.value == 0) {
        continue
      }
      count++
      queue.add(drawArray[k][j])
      while (queue.size > 0) {
        //bw.write("queue:" + queue.joinToString() + "\n") // + "$e.value"
        var e = queue.remove()
        /*틀림if (e?.visit == true) {
          //continue
        }*/
        if (e?.value == 0) {
          continue
        }
        /*틀림 if (e?.value == 1) {
          //count++
        }*/
        e.visit = true

        for (i in 0..3) {
          var iy = dir[i][0] + e.i
          var ix = dir[i][1] + e.j
          //bw.write("pos:" + "$iy" + "/" + "$ix" + "\n")
          if (ix < 0 || iy < 0 || ix >= m || iy >= n) {
            continue
          }
          var ee = drawArray[iy][ix]
          if (ee?.visit == true) {
            continue
          }
          if (ee?.value == 0) {
            continue
          }
          ee?.visit = true
          if (ee?.value == 1) {
            count++
          }
          queue.add(ee)
        }
      }
      numOfDrawing++
      //bw.write("$count" + "\n")
      if (maxArea < count) {
        maxArea = count
      }
      count = 0
    }
  }
  bw.write("$numOfDrawing" + "\n")
  bw.write("$maxArea")
  
  bw.flush()
  bw.close()
}
