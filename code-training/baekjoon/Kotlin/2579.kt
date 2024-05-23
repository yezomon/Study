import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.math.BigInteger
import kotlin.math.*
// 2579
// 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
// 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
// 마지막 도착 계단은 반드시 밟아야 한다.
// Todo. 큰수를 밟는게 유리한거같긴 한데 dp인지 그리디인지 헷갈림, 동전 적게쓰는 문제랑 비슷한거같은데 동전문제는 dp가 아닌거같은데 -> 슬라이딩 윈도우처럼 푸는건 안되나.
// 거꾸로 시작하는법 해보기
//https://www.acmicpc.net/board/view/129752
/*테케
6
10
20
15
25
10
20
정답 75

6
1
3
5
7
9
0
# Ans : 17 : 3 5 9 0
4
1 10 10 1
답 : 12
출력 20

[입력]
5
10
100
1
1
1
[출력]
102
[정답]
112
https://www.acmicpc.net/board/view/136542

내가만든 사례
6
12
20
100
10
1
1 
답 : 123

7
12
20
100
10
1
1
1
출력: 122? 
답 : 124?

4
1
110
10
1
답 112 
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
  var arr0 = Array<Int>(n+3,{0}) //0~n+1
  
  for(i in 1..n){
    arr0[i] = br.readLine().toInt()
  }
 var count = 0
  var arrSum :Array<Array<Int>> = Array(n+3){Array(2){0}}//Array<Int>(n+2,{0})
   arrSum[1][0] = arr0[1] //n-1
   arrSum[1][1] = arr0[1] //n-2
 /*for(i in n downTo 2){  ////for (i in n-1 downTo 1)
    bw.write("${arrSum.joinToString()}\n")
   if(count>0){
     // arrSum[i-1] = arr0[i-2] + arrSum[i]
     // count = 0
     // bw.write("${i}*${arrSum[i-1]} ${arr0[i-2]} ${arrSum[i]}\n")
     // continue
   }
   arrSum[i-1][0] = arr0[i-1] + arrSum[i][0] //max(arr0[i-1] + arrSum[i], arr0[i-2] + arrSum[i])
   
   bw.write("${i}/${arrSum[i-1]} ${arr0[i-1]} ${arrSum[i]}\n")
   count++
 }*/
 /* for(i in n-1 downTo 2){
    if(i%2!=0){
      
      //continue
    }
    arrSum[i][0] = arr0[i] + arrSum[i+1][0] //5=4+6 4=3+5 3=2+4
    arrSum[i][1] = arr0[i] + arrSum[i+1][1] //5=3+6 4=2+5 3=1+4
    
    bw.write("${i}d ${arrSum[i].joinToString()}\n")
  }*/
  for(i in 2..n){
    arrSum[i][0] = max(arrSum[i-2][0], arrSum[i-2][1]) + arr0[i]//계단0개//arr0[i] + arrSum[i-1][0]  //20=2+0 3=3+1 4=4+2
    arrSum[i][1] = arrSum[i-1][0] + arr0[i]//계단1개 //arr0[i] + arrSum[i-1][1] //30=2+1 3=3+2 4=4+3
    if(count<max(arrSum[i][0],arrSum[i][1])){
      //count = max(arrSum[i][0],arrSum[i][1])
    }
    //bw.write("${i}/${arrSum[i].joinToString()}\n")
  }
 if(n<2){
   bw.write("${arr0[n]}")
 }else{
   var ans = max(arrSum[n][0],arrSum[n][1])
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

