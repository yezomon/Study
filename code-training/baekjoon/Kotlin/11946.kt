import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 11946
/*
대회에 참가한 팀의 수를 나타내는 n과(1<=n<=100) 문제 수 m(1<=m<=15), 그리고 채점 로그의 개수 q가 주어진다(0<=q<=10000).

 각 팀마다 팀 번호, 푼 문제 수, 총 시간을 출력
 각 팀의 등수는 문제를 많이 푼 순으로 산정된다.
 만약 푼 문제 수가 같을 경우 ‘총 시간’이 작은 순으로 산정된다.
 ‘총 시간’은 각 문제를 풀어서 통과했을 때의 시간 값을 더한 것이다. 각 문제를 풀어서 통과하면 대회 시작으로부터 통과할 때까지 걸린 분 수와 그 문제를 통과하기 이전의 틀린 답을 제출한 횟수에 20을 곱한 패널티를 더한다.

  q개의 줄에는 각 채점 정보가 주어진다. 채점 정보는 경과 시간(300이하의 음이 아닌 정수), 팀 번호(1부터 n까지의 자연수), 문제 번호(1부터 m까지의 자연수), 그리고 채점 결과로 이루어져 있다. 채점 결과는 “AC”, “RE”, “TLE”, “WA”중 하나이며 각각 “Accepted”, “Run-time Error”, “Time-limit Exceeded”, “Wrong Answer”를 의미한다(“Accepted”가 통과를 의미하며 나머지는 오답으로 간주된다). 채점 정보는 채점된 순서대로 입력된다. 즉 경과 시간 순으로 입력될 것이다.
 통과못한 문제는 패널티 계산 x
 2 2 7
 10 1 1 WA
 20 2 1 AC
 30 1 1 TLE
 30 2 2 RE
 30 1 1 AC
 45 2 1 WA
 100 1 2 AC

 2 2 6
 10 1 1 AC
 10 2 1 AC
 20 1 2 AC
 20 2 2 RE
 30 2 1 AC
 50 1 1 AC

 5 2 2
 199 3 2 AC
 200 1 1 RE
 team(i=2, solved=1, t=199), team(i=0, solved=0, t=0), team(i=1, solved=0, t=0), team(i=3, solved=0, t=0), team(i=4, solved=0, t=0)
 3 1 199
 1 0 0
 2 0 0
 4 0 0
 5 0 0
*/
data class team(var i: Int, var solved: Int, var t: Int) // 푼문제수, 총시간

data class question(var solved: Boolean, var c: Int) 

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var (n, m, q) = br.readLine().split(" ").map { it.toInt() } // 팀수 문제수 쿼리수
  var arr = Array(n) { Array<question>(m) { question(false, 0) } } // 팀번호,문제번호,오답제출횟수.
  var results = Array<team>(n) { team(0, 0, 0) } // 팀번호,푼수,시간
  for (i in 0..n - 1) {
    // arr[i] = Array<question>(n){ question(false,0) }  //팀번호, 문제풀이여부, 총시간
    results[i].i = i
    results[i].solved = 0
    results[i].t = 0
  }

  repeat(q) {
    var s = br.readLine().split(" ") // 시간 팀 문제 결과
    if (s[3] == "AC" && !arr[s[1].toInt() - 1][s[2].toInt() - 1].solved) {
      // arr[s[1].toInt()][s[2].toInt()] = Pair(true,s[0].toInt() +
      // arr[s[1].toInt()][s[2].toInt()].second * 20)
      arr[s[1].toInt() - 1][s[2].toInt() - 1].solved = true
      results[s[1].toInt() - 1].t += s[0].toInt() + arr[s[1].toInt() - 1][s[2].toInt() - 1].c * 20
      results[s[1].toInt() - 1].solved += 1
      
    } else if(s[3] != "AC" && !arr[s[1].toInt() - 1][s[2].toInt() - 1].solved) {
      // arr[s[1].toInt()][s[2].toInt()] = Pair(false,s[0].toInt() +
      // arr[s[1].toInt()][s[2].toInt()].second)
      arr[s[1].toInt() - 1][s[2].toInt() - 1].c += 1
    }
    //bw.write(results.joinToString() + "\n")
  }
  results.sortWith(
      compareBy({-it.solved}, {it.t}, {it.i}) // 내림차순 오름차순 오름차순 
  )
  bw.write(results.joinToString() + "\n")
  results.forEach { bw.write("${it.i+1} ${it.solved} ${it.t}\n") }
  // var s = StringBuilder() //LinkedList<Char>()
  // var a = s.count{it=='A'}

  // t x m
  // var m = mutableMapOf<String,Int>()
  // repeat(n){
  //   var condition = br.readLine().split(",")
  //   var combination = br.readLine().split("|")
  //   var minV = Integer.MAX_VALUE
  //   for(i in 0..condition.size-1){
  //     var c = condition[i].split(":")
  //     m[c[0]] = c[1].toInt()
  //   }

  //   for(i in 0 until combination.size){
  //       var cb = combination[i].split("&")
  //       var sum = cb.map { m[it]!! }.max()
  //       minV = min(sum,minV)
  //   }

  //   bw.write("$minV\n")
  // }

  // var m = TreeMap<Int, Int>()
  // bw.write(m.toList().joinToString() + "\n")
  // val result = arr3.flatten().count { it == 1 }
  // var arr = LinkedList<Pair<Int, Int>>()

  // arr.sortWith(
  //     compareBy<Pair<Int, Int>>({ it.first }) //오름차순
  //     .thenByDescending({ it.second }) //내림차순
  //     // .thenBy({ it.third })
  //     // .thenByDescending({ it.fourth })
  //     )

  // arr.sortWith(compareByDescending<Pair<Int, Int>>({ it.first }).thenBy({ it.second }))

  // bw.write(arr.joinToString() + "\n")

  // 5등의 문제 수 찾기
  // val fifth = arr[4].first
  // val count = arr.drop(5).count { it.first == fifth }

  // bw.write("$count")
  bw.flush()
  bw.close()
}
