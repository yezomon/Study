import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 11047
// 동전
/*

*/
//동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임) 
//data class Node(var y: Int, var x: Int, var visit: Boolean, var value: Int)

fun main() {
  // println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
 
  var s = br.readLine().split(" ")
  var n = s[0].toInt() //10
  var k = s[1].toInt() //4200
  var arr:Array<Int> = Array<Int>(n,{0})
  
  for(i in 0..n-1){
    var c = br.readLine().toInt()
    arr[i] = c
  }
  var answer : Int = 0 
  for(i in 0..n-1){ //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임) 
    answer += k/arr[n-1-i]
    k%=arr[n-1-i]
    bw.write("${arr[i]}\n")
  }

  bw.write("${answer}")
  /*if(t%5!=0 || t%3!=0 || t%3!=5 || t%5!=3 || t%8!=3 || t%8!=5){
    bw.write("${-1}")
  }*/

  /*var s = br.readLine()
  var answer : Int = 0
  for(i in 0..t-1){
    answer += s[i].digitToInt()
   //bw.write("${s[i].code}\n")
  }
  bw.write("${answer}")*/
  
  // var arr: Array<Int> = Array<Int>(10001, { 0 })
  /*var dir =
      arrayOf(
          arrayOf(0, 1),
          arrayOf(1, 0),
          arrayOf(-1, 0),
          arrayOf(0, -1)
      )*/ // var dir:Array<Array<Int>> = Array(4){Array(2){0}}

  // bw.write(numList.joinToString())
  // var words = HashMap<String,Int>() //k,v
  // words.containsKey('a')
  // var q :LinkedList<Int> = LinkedList<Int>()
  // var ts = TreeSet<Int>()
  // bw.write("${nf/kf}")

  bw.flush()
  bw.close()
}


