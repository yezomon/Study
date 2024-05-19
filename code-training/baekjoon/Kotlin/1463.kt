import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
// 1463
// Todo. 무조건 3으로 많이 나눠야 유리함 (동전문제랑 유리한듯..?근데 동전은 dp가 아닌데)
/*테케
입력
100

출력
10

정답
7

작성하신 코드

56 →→→ 7 → 6 → 2 → 1 (6번)

정답

56 → 28 → 27 → 9 → 3 → 1 (5번)

input:
100007
output:
22
answer:
21
https://www.acmicpc.net/board/view/19169
https://www.acmicpc.net/board/view/138662
*/
//data class Node(var y: Int, var value: String, var date: Int
var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  // var n = br.readLine().toInt()
  // var arr:Array<Int> = Array<Int>(n,{0})
  // var answer : Int = Integer.MAX_VALUE//-1
  // var st = LinkedList<Int>() //stack
  var n = br.readLine().toInt() //0~40사이의수
  var arr0 = Array<Int>(1000001,{0})
  arr0[1] = 0
  arr0[2] = 1
  arr0[3] = 1
  // arr0[4] = 2
  // arr0[5] = 3
  // arr0[6] = 2
  // arr0[7] = 3
  // arr0[8] = 3
  // arr0[9] = 2 
  // arr0[10] = 3
  for(i in 4..1000000){
    var a = i
    if(a%3==0&&a%2==0){
      //a = a/3
      arr0[i] = min(arr0[a/3],arr0[a/2])+1
      if(i==n){
        bw.write("3*${arr0[a]}\n")
      }
    }else if(a%3==0){
      //a = a/3
      arr0[i] = min(arr0[a/3],arr0[a-1])+1
      if(i==n){
        bw.write("3-1*${a} ${arr0[a]}\n")
      }
    }else if(a%2==0){
    //a = a/2
    arr0[i] = min(arr0[a/2],arr0[a-1])+1
    if(i==n){
      bw.write("3-1*${a} ${arr0[a]}\n")
    }
   }else {
      a = a-1
      arr0[i] = arr0[a]+1
      if(i==n){
        bw.write("2-1*${arr0[a]}\n")
      }
    }
  }
  bw.write("${arr0[n]}")
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
