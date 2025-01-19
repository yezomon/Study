import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*

// 15876
/*
var lists = mutableListOf<Char>() 
  for(i in 0..nk5+1){
    var b = Integer.toBinaryString(i).split("")
    var bc = b.toTypedArray()
    lists.addAll(bc.flatMap { it.toCharArray().toList() })
  }
그럼 이부분에서 왜 메모리초과가날까요
문제를 찾아보겠습니다:

1. Integer.toBinaryString(i)는 문자열을 생성
2. split("")으로 각 문자를 분리해 리스트 생성
3. toTypedArray()로 새로운 배열 생성
4. flatMap으로 다시 리스트 생성
5. toCharArray()로 다시 배열 생성
6. toList()로 또 리스트 생성

매 반복마다 6개의 새로운 객체가 생성되고 있습니다!

더 효율적인 방법:
```kotlin
var lists = mutableListOf<Char>()
for(i in 0..n*k*5+1) {
    Integer.toBinaryString(i).forEach { 
        lists.add(it)
    }
}
```

또는 StringBuilder를 사용하면 더 효율적일 수 있습니다:
```kotlin
val sb = StringBuilder()
for(i in 0..n*k*5+1) {
    sb.append(Integer.toBinaryString(i))
}
val lists = sb.toString().toList()
```
*/
// data class team(var i: Int, var solved: Int, var t: Int) // 푼문제수, 총시간

fun main() {
  val br = BufferedReader(InputStreamReader(System.`in`))
  val bw = BufferedWriter(OutputStreamWriter(System.out))
  var (n, k) = br.readLine().split(" ").map { it.toInt() } 
  // var arr = Array(n) { Array<question>(m) { question(false, 0) } } // 팀번호,문제번호,오답제출횟수.
  // var results = Array<team>(n) { team(0, 0, 0) } // 팀번호,푼수,시간
  //var lists = mutableListOf<Char>() 
  //시간 초과 
  // for(i in 0..n*k*5+1){
  //   var b = Integer.toBinaryString(i).split("")
  //   var bc = b.toTypedArray()
  //   lists.addAll(bc.flatMap { it.toCharArray().toList() })
  // }
  val sb = StringBuilder()
  for(i in 0..n*k*5+1) {
      sb.append(Integer.toBinaryString(i))
  }
  val lists = sb.toString().toList()
  //bw.write(lists.joinToString()+"\n")
  //4 1 -> 0, 4,  8, 12
  var cnt = 0 
  for(i in 0..n*k*5+1){
    if(i%n==(k-1) && cnt < 5){
      bw.write(lists.get(i)+"")
      cnt++
      //bw.write(" ")
    }
    if(i%n==(k-1) && cnt<5){
      bw.write(" ")
    }
  }

  bw.flush()
  bw.close()
}
/*
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
*/
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
