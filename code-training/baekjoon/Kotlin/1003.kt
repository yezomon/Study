import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

import kotlin.math.*
// 1003 fibonacci 피보나치

var br = BufferedReader(InputStreamReader(System.`in`))
var bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
  var n = br.readLine().toInt() //0~40사이의수
  var arr0 = Array<Int>(41,{0})
  arr0[0] = 1
  arr0[1] = 0
  arr0[2] = 1
  //arr0[3] = 1
  var arr1 = Array<Int>(41,{0})
  arr1[0] = 0
  arr1[1] = 1
  arr1[2] = 1
  //arr0[3] = 2
  for(i in 2..40){
    arr0[i] = arr0[i-2]+arr0[i-1]
    arr1[i] = arr1[i-2]+arr1[i-1]
  }
  for(i in 1..n){
    var v = br.readLine().toInt()
    bw.write("${arr0[v]} ${arr1[v]}\n")
  }

  bw.flush()
  bw.close()
}

