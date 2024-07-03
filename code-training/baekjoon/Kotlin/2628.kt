import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.*

// 2628
fun main() {
  // println("Hello world!")
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  // var n = s[0].toInt() //10
  // var coin:Array<Int> = arrayOf(25,10,5,1)
  // var answer : Int = Integer.MAX_VALUE
  //var arrA: Array<Int> = Array<Int>(n, { 0 })
  var s = br.readLine().split(' ')//.map({ it.toInt() }).toTypedArray()
  var n = br.readLine().toInt()
  //a.sortWith(compareBy({it}))
  //b = b.sorted().reversed().toTypedArray()
  var h : LinkedList<Int> = LinkedList<Int>()
  var v : LinkedList<Int> = LinkedList<Int>()
  h.add(0)
  h.add(s[1].toInt())
  v.add(0)
  v.add(s[0].toInt())
  for(i in 0..n-1){
    var d = br.readLine().split(' ')
    if (d[0].toInt()==0){ //가로
      h.add(d[1].toInt())
    }else if (d[0].toInt()==1){ //세로
       v.add(d[1].toInt())
    }
  }
  
  h.sort()
  v.sort()
  var hmax:Int = Integer.MIN_VALUE
  for(i in 1..h.size-1){
    if(hmax<h[i]-h[i-1]){
      hmax = h[i]-h[i-1]
    }
  }
  var vmax:Int = Integer.MIN_VALUE
  for(i in 1..v.size-1){
    if(vmax<v[i]-v[i-1]){
      vmax = v[i]-v[i-1]
    }
  }
  //bw.write("${h.joinToString()}\n")
  //bw.write("${v.joinToString()}\n")
  //bw.write("${vmax} ${hmax}\n")
  bw.write("${vmax*hmax}")
  // for(i in 0..n-1){  //동전은 오름차순으로 주어짐(앞뒤 동전은 서로 배수임)
  //   //answer += k/arr[n-1-i]
  //   //k%=arr[n-1-i]
  //   //bw.write("${arr[i]}\n")
  // }
  
  bw.flush()
  bw.close()
}
