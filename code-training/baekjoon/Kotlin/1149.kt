import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.math.BigInteger
import kotlin.math.*
// 1149
// RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
// 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
// 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
// N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
// i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
// Todo. 
// https://www.acmicpc.net/board/view/129752
/*테케
3
26 40 83
49 60 57
13 89 99
답 96
3
1 100 100
100 1 100
100 100 1
답 3
3
1 100 100
100 100 100
1 100 100
답 102
*/
//data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  // var n = br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack
var n = br.readLine().toInt() //0~1000사이의수
  //var arr0 = Array<BigInteger>(n+2,{"0".toBigInteger()}) // Array(n+2){it.toBigInteger()}   // n+1로 하면 런타임에러가 발생합니다. n=0일때.
var arr0 :Array<Array<Int>> = Array(n+3){Array(3){0}}//Array<Int>(n+3,{0}) //0~n+1
for(i in 1..n){
  var s = br.readLine().split(' ')
  arr0[i][0] = s[0].toInt() //빨
  arr0[i][1] = s[1].toInt() //초
  arr0[i][2] = s[2].toInt() //파
}
//var count = 0
var arrSum :Array<Array<Int>> = Array(n+3){Array(3){0}} //i번째까지 칠하는 비용의 최솟값 //Array<Int>(n+2,{0}) 
arrSum[1][0] = arr0[1][0]  //n-1
arrSum[1][1] = arr0[1][1]  //n-2
arrSum[1][2] = arr0[1][2] 
bw.write("/${arrSum[1].joinToString()}\n")
for(i in 2..n){
    arrSum[i][0] = min(arrSum[i-1][1], arrSum[i-1][2]) + arr0[i][0] //빨강 
    arrSum[i][1] = min(arrSum[i-1][0], arrSum[i-1][2]) + arr0[i][1]  //초록
    arrSum[i][2] = min(arrSum[i-1][0], arrSum[i-1][1]) + arr0[i][2] //파랑 
    //arrSum[i][0] = max(arrSum[i-2][0], arrSum[i-2][1]) + arr0[i]//계단0개//arr0[i] + arrSum[i-1][0]  //20=2+0 3=3+1 4=4+2
    //arrSum[i][1] = arrSum[i-1][0] + arr0[i]//계단1개 //arr0[i] + arrSum[i-1][1] //30=2+1 3=3+2 4=4+3
    bw.write("${i}/${arrSum[i].joinToString()}\n")
}

if(n<2){
   bw.write("${arr0[n].min()}")//bw.write("${arr0[n]}")
}else{
   var ans = arrSum[n].min() //max(arrSum[n][0],arrSum[n][1])
   bw.write("${ans}")
}
 
  /*
  var answer = arr0[n]
  var i = n 
  while( 0<i ){
    var a = i-1
    var b = i-2
    var c = i-3
    var d = i-4
    if (a < 0) { a = 0 }
    if (b < 0) { b = 0 }
    if (c < 0) { c = 0 }
    if (d < 0) { d = 0 }
    var tinyArr = listOf(Pair(arr0[b]+arr0[d],4),Pair(arr0[b]+arr0[c],3),Pair(arr0[a]+arr0[c],3)) //35 34 24
    bw.write("${i}/${tinyArr.maxOfOrNull {it.first}}/${tinyArr.maxOfOrNull {it.second}}\n")
    answer+= tinyArr.maxOf{it.first}
    i = i-tinyArr.maxOf {it.second}
     bw.write("i:${i}\n")
  }*/
  
  /*
  var s = br.readLine().split(' ')
  var n = s[0].toInt()
  var m = s[1].toInt()
  var hn = TreeSet<String>()
  var hm = TreeSet<String>()
  for(i in 0..n-1){
    var ss = br.readLine()
    hn.add(ss)
  }*/

  //var isUsedArr = Array<Boolean>(10,{false})
  //var arr = Array<Int>(10,{0}) //왜10개
  //BackTracking(0, n,m,isUsedArr,arr)
  //bw.write("${answer}")
  /*
  var people = HashMap<String, Int>() //TreeSet과 차이점..? 
  for(i in 0..n-1){
    var s = br.readLine().split(' ')
    if(people.containsKey(s[0])){
      people.remove(s[0])//people[s[0]] = 0 //퇴장
    }else{
      people[s[0]] = 1 //입장 
    }
  }
  var keys = people.keys.toList().sorted().reversed()

  var values = people.values.toList()
  for(i in 0..keys.size-1){
    bw.write("${keys[i]}\n")
  }
  */
  /*
  var arr = Array<Node?>(s) { null }
  for (i in 0..s - 1) {
    var ss = br.readLine().split(' ')
    arr[i] = Node(ss[0].toInt(), ss[1], i)
  }
  arr.sortWith(compareBy({ it?.y }, { it?.date }))
  arr.forEach { bw.write("${it?.y} ${it?.value}\n") }
*/
  /* var last = 0
  for (i in 0..a.length-1) {
    if(n-i<0){
      continue
    }
   // bw.write("${n-i} ${i}\n")
   bw.write("${a[i]} ${b[n-i]}\n")
    if(a[i]!=b[n-i]){
      last++
    }
  }
  bw.write("last${last}\n")*/

  /*
  if(s[i] < min){
    minV = min(minV,s[i])
  }
  if(s[i] > max){
    maxV = max(maxV,s[i])
  }*/

  /*
  if( answer == Integer.MAX_VALUE){
    bw.write("${-1}")
  }else{
    bw.write("${answer}")
  }
  for(i in 0..n-1){ //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임)
    //answer += k/arr[n-1-i]
    //k%=arr[n-1-i]
    //bw.write("${arr[i]}\n")
  }*/

  /*
    var answer : Int = 0
    for(i in 0..t-1){
      answer += s[i].digitToInt()
     //bw.write("${s[i].code}\n")
    }
  */

  /*var dir =
  arrayOf(
      arrayOf(0, 1),
      arrayOf(1, 0),
      arrayOf(-1, 0),
      arrayOf(0, -1)
  )*/
  // var dir:Array<Array<Int>> = Array(4){Array(2){0}}

  // bw.write(numList.joinToString())
  // var words = HashMap<String,Int>() //k,v
  // words.containsKey('a')
  // var q :LinkedList<Int> = LinkedList<Int>()
  // var ts = TreeSet<Int>()
  // bw.write("${nf/kf}")

  bw.flush()
  bw.close()
}
