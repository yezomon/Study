import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 1012
// 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과
// 세로길이 N(1 ≤ N ≤ 50), 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1),
// Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.
// Todo. 1926번 코드랑 비교해볼것.  반복문이 많이 반복되는데 줄일방법 알아보기. 코틀린스럽게 바꾸는법 알아보기 

data class Node(var y: Int, var x: Int, var visit: Boolean, var value: Int)

fun main() {
  // println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var arr:Array<Int> = Array<Int>(n,{0})
  var t = br.readLine().toInt()

  // var arr: Array<Int> = Array<Int>(10001, { 0 })
  var dir =
      arrayOf(
          arrayOf(0, 1),
          arrayOf(1, 0),
          arrayOf(-1, 0),
          arrayOf(0, -1)
      ) // var dir:Array<Array<Int>> = Array(4){Array(2){0}}

  for (i in 1..t) {
    var s = br.readLine().split(" ")
    var m = s[0].toInt() // 가로 x
    var n = s[1].toInt() // 세로 y
    var arr: Array<Array<Node?>> = Array(n) { Array(m) { null } }
    var queue: Queue<Node> = LinkedList<Node>()
    var numOfBunch = 0
    var k = s[2].toInt()
    for (j in 1..k) { // 배추위치
      var ss = br.readLine().split(" ")
      var x = ss[0].toInt()
      var y = ss[1].toInt()
      arr[y][x] = Node(y, x, false, 1)
    }
    for (y in 0..n - 1) { // 초기화
      for (x in 0..m - 1) {
        if (arr[y][x] == null) {
          arr[y][x] = Node(y, x, false, 0)
        }
      }
    }
    // BFS
    for (y in 0..n - 1) {
      for (x in 0..m - 1) {
        if (arr[y][x]?.value == 0||arr[y][x]?.visit==true) {continue} //
        queue.add(arr[y][x])
        while (queue.size > 0) {
          var e = queue.remove()
          e.visit=true
          for (d in 0..3) {
            var ex = e.x + dir[d][1]
            var ey = e.y + dir[d][0]
            if (ex < 0 || ey < 0 || ex >= m || ey >= n) {
              continue
            }
            var e2 = arr[ey][ex]
            if (e2?.visit == true || e2?.value == 0) {
              continue
            }
            e2?.visit = true
            queue.add(e2)
          }
          //numOfBunch++
        }
         numOfBunch++
      }
    }

    bw.write("${numOfBunch}\n")
  }

  /* 메모리초과 나는 코드
  var numList:LinkedList<Int> = LinkedList<Int>()
  for (i in 1..a){
     var b = br.readLine().toInt()
     numList.add(b)
  }
  var p = numList.sort()
  numList.forEach({it->bw.write("${it}\n")})
  */
  // bw.write(numList.joinToString())

  // var words = HashMap<String,Int>() //k,v
  // words.containsKey('a')
  // var q :LinkedList<Int> = LinkedList<Int>()
  // var ts = TreeSet<Int>()
  // bw.write("${nf/kf}")

  bw.flush()
  bw.close()
}
