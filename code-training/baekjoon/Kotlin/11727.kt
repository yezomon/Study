import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.math.BigInteger
import kotlin.math.*

// 11727
// 2×n 크기의 직사각형을 1×2, 2×1, 2x2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

//첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
// 
// Todo. 1이랑 2로 숫자 만드는 수열인데 이거 N과 M문제아님? 그럼 백트래킹인데? 왜 이게 dp ?? 이거랑 비슷한 리트코드 문제 있던거같은데? 
// 왜 이게 피보나치 같은 수열로 되는건지 이해가 안됨. 이론적으로 왜? 
// https://blog.encrypted.gg/737
// 반례
// https://www.acmicpc.net/board/view/91259
// 1 -> 1 / 2 ->(2) 11 2 / 3 ->(3) 12 21 111 / 4 ->(5) 1111 112 211 121 22 / 5->(8) 11111 1112 1121 1211 2111 122 212 221  6-> 13 7-> 21 8 -> 34 9 -> 55개
// 1 -> 1 / 2 -> 3 2의갯수1개*2+1/ 3-> 5 2의갯수2개*2+1/ 4-> 11 2의갯수5개*2+1/ 5-> ?21 2의갯수10개 *2 +1 / 6 ->  / 7 -> 8->171 / 9-> /  10-> / 11 -> 12 -> 2731
// 11111 
/*테케
2
답 3
8
답 121
12
ekq 2731
*/
//data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  // var n = br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack  ArrayList
var n = br.readLine().toInt() //0~1000사이의수
var i = 4
var arr = Array<Long>(n+4, {0}) //2*n arr[i] i번째 의 가짓수 1,2,3,-> 2,4,6
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
//var arr0 = Array<BigInteger>(n+2,{"0".toBigInteger()}) // Array(n+2){it.toBigInteger()}   // n+1로 하면 런타임에러가 발생합니다. n=0일때.
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

  bw.flush()
  bw.close()
}

