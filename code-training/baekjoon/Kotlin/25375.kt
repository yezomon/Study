import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*


// with claude. 
// 최대공약수 gcd응용 

fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  //var s = br.readLine().split(' ').map{it.toInt()}.toIntArray() // a뜀 b뜀 a시작점 b시작점 
  var n = br.readLine().toInt()
  //bw.write(s.joinToString()+"\n")
  //
  var f = -1
  for(i in 0..n-1){
      var ab = br.readLine().split(' ') // a최대공약수 b합 
      val sum = ab[1].toLong()
      val target = ab[0].toLong()
      // sum의 절반까지만 확인, target의 배수만 확인
      for(j in target..sum/2 step target){
          val other = sum - j
          if(other < 1) continue
          if(gcd(other, j) == target){
              bw.write("1")
              f = 1
              break
          }
      }
      if(f!=1){
          bw.write("0")
      }
      bw.write("\n")
      f = -1
  }
  
  //bw.write("$nm\n")
  //var ss = nm.toString().reversed().toInt() 
  //var ts = TreeSet<Int>()
  
  // 5*4*3 = 60
  bw.flush()
  bw.close()
}

// 최대공약수
fun gcd(a: Long, b: Long): Long {
  var x = a
  var y = b
  while (y != 0L) {
    val temp = y
    y = x % y
    x = temp
  }
  return x
}
