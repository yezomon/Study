import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import java.math.BigInteger
import kotlin.math.*

// 9095
// 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
// 1+1+1+1
// 1+1+2
// 1+2+1
// 2+1+1
// 2+2
// 1+3
// 3+1
// 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
// 1->1 / 2-> 11 2 / 3-> 111 12 21 3 / 4->7 / 5-> 11111 1112 1121 1211 2111 122 212 221 113 311 131 23 32 (13)
// https://blog.encrypted.gg/974
/*테케
3
4
7
10
답
7
44
274
//4를 만드는 법. 1일때 -> 
*/
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {

var t = br.readLine().toInt() //0~1000사이의수
var arr = Array<Int>(11+1,{1})
arr[1] = 1
arr[2] = 2
for(i in 3..11){
  arr[i] = arr[i-1] + arr [i-2] + arr[i-3]
}
for(i in 1..t){
  var s = br.readLine().toInt()
  bw.write("${arr[s]}\n")
}
    
  bw.flush()
  bw.close()
}
