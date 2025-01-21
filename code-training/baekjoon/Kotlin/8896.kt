import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 8896
/*
상근이는 가위 바위 보를 할 수 있는 로봇을 가지고 있다. 게임은 총 k번의 연속적인 라운드로 이루어져 있다.

각 로봇은 길이가 k인 문자열을 가지고 있고, 이 문자열에 의해서 게임을 하게 된다. 각 라운드에서 패배한 로봇은 더 이상 게임을 참여할 수 없고, 남은 로봇끼리 게임을 하게 된다. 로봇이 하나만 남은 경우에는 그 로봇이 게임을 승리하게 되고, 게임이 끝난다. k 라운드가 지난 후에 남아있는 로봇이 하나보다 많다면, 게임은 무승부로 끝난다.

가위는 S, 바위는 R, 보는 P로 나타낼 수 있다. 만약, 로봇이 가지고 있는 문자열이 RSPSRSSP 라면, 첫 라운드에서 로봇은 주먹을 내고, 둘째 라운드에서는 가위를 낸다. 여덟번째 라운드까지 그 로봇이 살아있다면 보를 낸다.

가위 바위 보 게임에 참여하는 로봇의 수와 각 로봇의 문자열이 주어졌을 때, 게임의 승자를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫째 줄에는 참여하는 로봇의 수 N이 주어진다. 다음 N개 줄에는 각 로봇에 저장되어 있는 문자열이 주어진다. 모든 로봇의 문자열의 길이는 k이다. (2 ≤ N ≤ 10, 3 ≤ k ≤ 30) 로봇은 주어지는 순서대로 1번부터 번호를 매긴다.

출력
각 테스트 케이스마다, 게임을 승리한 로봇의 번호를 출력한다. k 라운드가 지난 후에도 승자가 없는 경우 (무승부) 에는 0을 출력한다.

3
5
RPSSSPR
SSRPRPS
PRSSRSP
RRRPSPP
SSSSSRP
4
RPSPSPSPRPRPSR
SPSSRRRSSRPRRR
RSPRPPPPSSRPSR
PRRSSSRRPRSRRR
3
SPPPSS
SPRRRR
SSSSPP
*/
// data class team(var i: Int, var solved: Int, var t: Int) // 푼문제수, 총시간

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  // var (n, m, q) = br.readLine().split(" ").map { it.toInt() } // 팀수 문제수 쿼리수
  // var arr = Array(n) { Array<question>(m) { question(false, 0) } } // 팀번호,문제번호,오답제출횟수.
  // var results = Array<team>(n) { team(0, 0, 0) } // 팀번호,푼수,시간

  var t = br.readLine().toInt() // 테케
  repeat(t) {
    var n = br.readLine().toInt()
    var loser = mutableSetOf<Int>()
    var winers = mutableListOf<Int>() 
    var lists = mutableListOf<Pair<Int, Array<String>>>()
    for(i in 0..n-1) { // 로봇
      var s = br.readLine().split("")
      lists.add(Pair(i+1,s.toTypedArray())) 
      winers.add(i+1)
    }
    // 이긴거 RSP 체크
    for (i in 0..lists[0].second.size - 1) { //문자열길이만큼 
      // var arr = Array(3) { 0 }
      //var results = StringBuilder()
      var r=0
      var s=0
      var p=0 
      for (j in 0..n - 1) { //승자찾기
        if(loser.contains(lists[j].first)){ 
          continue
        }
        when{
          lists[j].second[i]=="R" ->{r++}
          lists[j].second[i]=="S" ->{s++}
          lists[j].second[i]=="P" ->{p++}
        }
      }
      var winner = when{
        r>0 && s>0 && p>0 ->{continue}//무승부 
        r>0 && s>0 && p<1 ->{"R"} //r
        r>0 && s<1 && p>0 ->{"P"} //p
        r<1 && p>0 && s>0 ->{"S"} //s
        else -> {continue} //전부같은것만 낸경우 무승부 
      }
      //bw.write("$i $winner\n") 
      for (j in 0..n - 1) { //패자제외 
        if(loser.contains(lists[j].first)){ 
          continue
        }
        if(lists[j].second[i]!=winner){
          loser.add(lists[j].first)
          winers.remove(lists[j].first)
        }
      }

    }
    //bw.write(winers.joinToString()+"\n")
    if(winers.size != 1 ) bw.write("0\n") else bw.write(winers.get(0).toString()+"\n") 

  }

  bw.flush()
  bw.close()
}

// results.sortWith(
//     compareBy({-it.solved}, {it.t}, {it.i})
// )
// bw.write(results.joinToString() + "\n")
// results.forEach { bw.write("${it.i+1} ${it.solved} ${it.t}\n") }
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
// results.append(lists[j][i])
// var results = when {
//   lists[j].second[i]=="R" ->1
//   lists[j].second[i]=="S" ->3
//   lists[j].second[i]=="P" ->5 
//   else
// }
// if (results.any() { it == 'R' } && results.any() { it == 'S' } && results.any() { it == 'P' }
// ) {} else if (results.any() { it == 'R' } && results.any() { it == 'S' }) { // R
// } else if (results.any() { it == 'R' } && results.any() { it == 'P' }) { // P
// } else { // S
// }
