// 18512 
// Think. 베주 항등식을 사용한 방법(O(log n))이나 유클리드 호제법(O(log n))에 비해 매우 비효율. 디오판토스 방정식의 해의 존재성을 판별하는 중요한 기준 

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 18512  
// Todo.
fun main() {
  var br = BufferedReader(InputStreamReader(System.`in`))
  var bw = BufferedWriter(OutputStreamWriter(System.out))
  var s = br.readLine().split(' ').map{it.toInt()}.toIntArray() // a뜀 b뜀 a시작점 b시작점 
  //bw.write(s.joinToString()+"\n")
  var result = -1
  for(i in 0..100){
    var ss : Double = s[0].toDouble() * i + (s[2] - s[3])
    var y : Double = (ss.toDouble()/s[1])
    if(y>=0 && y % 1.0 == 0.0) { //isInteger
      result = s[0] * i + s[2]
      bw.write("$result")
      break
    }
  }
  if(result<0){
    bw.write("-1")
  }

  bw.flush()
  bw.close()
}
