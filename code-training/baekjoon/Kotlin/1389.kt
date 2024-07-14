import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// 1389
// 
// 케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임이다.
// 예를 들어, BOJ의 유저가 5명이고, 1과 3, 1과 4, 2와 3, 3과 4, 4와 5가 친구인 경우를 생각
// 사람이 여러 명일 경우에는 번호가 가장 작은 사람을 출력한다.
// 사람의 번호는 1부터 N까지이며, 두 사람이 같은 번호를 갖는 경우는 없다.
/*테케
5 5
1 3
1 4
4 5
4 3
3 2
*/
// data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  var nm = br.readLine().split(' ') //학생수, 관계수 
  var n = nm[0].toInt()
  var m = nm[1].toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack  ArrayList
  // var arr = Array<Int>(n,{0})
  var arr = Array(n + 1, { Array(n + 1) { 0 } })
  var q : Queue<Int> = LinkedList<Int>() 
  for (i in 1..m) {
    var s = br.readLine().split(' ')
    var s0 = s[0].toInt()
    var s1 = s[1].toInt()
    arr[s0][s1] = 1
    arr[s1][s0] = 1
  }
  //var visit = Array(n+1) { -1 } //unvisit
 // var sums = Array(n+1) {0}
  // q.add(1)
  // visit[1]=0
  var min = Integer.MAX_VALUE
  var maxIdx = -1
  for(i in 1..n){
    var visit = Array(n+1) { -1 } //unvisit
    q.add(i)
    visit[i] = 0 //초기값 이자 방문했다는 flag
    //1, 34, 42, 25
    //2 ,3, 14, 45
    //3, 124, 5
    //4 , 135, 2
    //5, 4, 13, 2
    while(!q.isEmpty()){
      var e = q.remove() //q.poll() //dequeue()
      for(j in 1..n){
        if(visit[j] == -1 && arr[e][j] == 1){
          visit[j] = visit[e]+1
          q.add(j)
        }
      }
    }
    //bw.write("v:${visit.joinToString()}\n")
    var sum = 0
    for(j in 1..n){
      sum += visit[j]
    }
    if(min>sum){
      min = sum
      maxIdx = i
    }
  }
  bw.write("${maxIdx}")
  /*var arr = Array<Long>(n+4, {0}) //2*n arr[i] i번째 의 가짓수 1,2,3,-> 2,4,6
  var i = 4
  arr[1] = 1
  arr[2] = 3
  arr[3] = 5
  //arr[4] = 11//5 21
  //arr[5] = 21
  while(i <= n){
    var sum : Long = 0
    for (j in 0..i){
     // sum += arr[j]
    }
   arr[i] = (arr[i-1]+arr[i-2]*2)%10007//arr[i-1]+arr[i-2]+3+(i-4)*2//sum+1 //arr[i-1]*2-1
   // arr[i] = (arr[i-2] + arr[i-1])%10007
    i++
  }
  bw.write("${arr[n]}")
    */
  // var arr0 = Array<BigInteger>(n+2,{"0".toBigInteger()}) // Array(n+2){it.toBigInteger()}   //
  // n+1로 하면 런타임에러가 발생합니다. n=0일때.
  /*
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
  }*/
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

  // var isUsedArr = Array<Boolean>(10,{false})
  // var arr = Array<Int>(10,{0}) //왜10개
  // BackTracking(0, n,m,isUsedArr,arr)
  // bw.write("${answer}")
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
