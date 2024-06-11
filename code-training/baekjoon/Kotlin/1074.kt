import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// 1074
// N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.
/*테케
4*4 2*2
0 1 4 5
2 3 6 7
8 9 12 13
10 11 14 15
https://www.acmicpc.net/board/view/108627
*/
// data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  var s = br.readLine().split(' ')
  var n = s[0].toInt()
  var r = s[1].toInt()
  var c = s[2].toInt()
 // var k = Math.pow(2.0, (n).toDouble())
  //var arr = Array(k.toInt()) {Array(k.toInt()) { 0 }}
  //ztracking(n, arr, 0,0,0,r,c)
  //bw.write("${arr[r][c]}")
  bw.write("${ztracking2(n, r, c)}")
  //var n = nm[0].toInt()
  //var m = nm[1].toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack  ArrayList
  /*
  var arr = Array(n + 1, { Array(n + 1) { 0 } })
  var q : Queue<Int> = LinkedList<Int>() 
  for (i in 1..m) {
    var s = br.readLine().split(' ')
    var s0 = s[0].toInt()
    var s1 = s[1].toInt()
    arr[s0][s1] = 1
    arr[s1][s0] = 1
  }*/
  //var visit = Array(n+1) { -1 } //unvisit
 // var sums = Array(n+1) {0}
  // q.add(1)
  // visit[1]=0
  /*
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
  }*/
  
  //bw.write("${maxIdx}")

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

fun ztracking2(n:Int, idx:Int, jdx:Int ):Int {
  if(n==0){
    return 0
  }
  var u =  Math.pow(2.0, (n-1).toDouble()).toInt()  // num02 << 1); // 곱하기 2
  if(idx<u && jdx<u){
    return ztracking2(n-1,idx,jdx)
  }
  if(idx<u && jdx>=u){
    return u*u + ztracking2(n-1,idx,jdx-u)
  }
  if(idx>=u && jdx<u){
    return 2*u*u + ztracking2(n-1,idx-u,jdx)
  }

  return 3*u*u + ztracking2(n-1,idx-u,jdx-u)
}

//16->88/ 8->44 / 4->22 
//정답에 해당하는 범위만 재귀 돌리게 바꿔야 시간초과가 안날듯. 
fun ztracking( n: Int, g:Array<Array<Int>>, idx:Int,jdx:Int,num:Int,x:Int,y:Int){ // 4,0,a,0,0,0
 // if(n<0){return}
  var c =  Math.pow(2.0, (n-1).toDouble()).toInt() // 64
 // bw.write("n${n} cnt${count} i${idx} j${jdx} num${num} c${c} \n")
  //bw.write("${g.joinToString()} \n")
  if (n==0){//(count == c*c) {
    g[idx][jdx] = num
    //g[idx][jdx + 1] = num + 1
    //g[idx + 1][jdx] = num + 2
    //g[idx + 1][jdx + 1] = num + 3
   // bw.write("${g[idx].joinToString()} \n")
    //bw.write("${g[idx + 1].joinToString()} \n")
    return
  }
  if(x<idx+c && y<jdx+c){
    return ztracking(n-1, g, idx, jdx, num,x,y) // 0 ~ (( 2^(n-1) * 2^(n-1) )) 0~63 0,0/0,3 3,0/3,3
  }
   if(x<idx+c && jdx+c<=y){
    return ztracking(n-1,  g, idx, jdx+c, num+c*c,x,y) // ((2^n-1 * 2^(n-1) )) ~ 2*(( 2^n-1 * 2^(n-1) )) 64~128 0,4/0.7 3.4/7.7
  }
   if(idx+c<=x && y<jdx+c){
    return ztracking(n-1,  g, idx+c, jdx, num+2*c*c,x,y) // 2*(( 2^n-1 * 2^(n-1) )) ~  3*(( 2^n-1 * 2^(n-1) )) 128~192
  }
   if(idx+c<=x && jdx+c<=y){
    return ztracking(n-1, g, idx+c, jdx+c, num+3*c*c,x,y) //  3*(( 2^n-1 * 2^(n-1) )) ~  4*(( 2^n-1 * 2^(n-1) )) 192~256
  }
  
}

fun BackTracking(k: Int, n: Int, m: Int, isUsedArr: Array<Boolean>, arr: Array<Int>) {
  // 출력
  if (k == m) { // 수열크기 m,  k는 트리의 depth이자 현재 채워진 수열의 숫자 갯수
    for (i in 0..m - 1) {
      bw.write("${arr[i]}")
      bw.write(" ")
    }
    bw.write("\n")
    return
  }
  // 수열생성
  for (i in 1..n) {
    if (isUsedArr[i] == false) {
      arr[k] = i
      for (j in 1..i - 1) {
        // isUsedArr[j] = true
      }
      // isUsedArr[i] = true
      BackTracking(k + 1, n, m, isUsedArr, arr)
      for (j in 1..i - 1) {
        // isUsedArr[j] = false
      }
      // isUsedArr[i] = false //???
    }
  }
}
