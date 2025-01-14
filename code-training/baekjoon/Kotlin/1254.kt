import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// 슬라이딩 윈도우(투포인터) 로 풀었는데.  인덱스 조건을 계속 틀려서 claude 도움. 
// 1254
/*
aaabbbaa
ans : 9
output : 14

abab
baba
bab5 

eeeffe
effeee
effe8

abdfhdyrbdbsdfghjkllkjhgfds

수정된 부분은 i = i - j + 1입니다.

불일치가 발생했을 때 현재 검사 중이던 부분 문자열의 길이(j)만큼 뒤로 가서
그 다음 위치(+1)부터 다시 검사를 시작하도록 합니다.

이렇게 하면:

첫 번째 'a'에서 시작해서 "aa"까지 매칭
'b'에서 불일치 발생하면 두 번째 'a'로 이동해서 다시 시작
이런 식으로 모든 위치에서 적절히 검사를 진행할 수 있습니다.
*/
fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  //var n = br.readLine().toInt() // .split(" ").map { it.toInt() }
  var s = br.readLine()
  var r = s.reversed()
  bw.write("$r\n")
  var i = 0 
  var j = 0
  var stack = LinkedList<Char>()
  while (i < s.length && j < s.length ) {
      if (s[i] == r[j]) {
        stack.add(s[i])
        j++
         i++
      } else {
        i = i - j + 1 
        j=0
        //j--
        stack.removeAll(stack)
        //continue
      }
     
      //var c = s[j]
      //if(stack.isNotEmpty()) bw.write(stack.joinToString("")+"\n")
  }

  bw.write(stack.joinToString(""))
  var result = ( s.length - stack.size )*2 +stack.size 
  bw.write("$result")
  //t x m
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
