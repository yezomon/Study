import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
//14492 
/*
3
1 1 0
0 1 0
0 0 1
1 0 0
1 1 1
0 0 1
*/
fun main() {
 val br = BufferedReader(InputStreamReader(System.`in`))
 val bw = BufferedWriter(OutputStreamWriter(System.out))
 var n = br.readLine().toInt()
 var arr = Array(n) { Array(n) { 0 } }
 var arr2 = Array(n){Array(n){0}}
 for (i in 0..n - 1) {
   var s = br.readLine().split(" ").map{it.toInt()}
   arr[i] = s.toTypedArray()
   //arr[i] = s.toCharArray().map { it.toString() }.toTypedArray()
 }
 for(i in 0..n-1){
   var s = br.readLine().split(" ").map{it.toInt()}
   arr2[i] = s.toTypedArray()
 }
 var arr3 = Array(n){Array(n){0}}
 for(i in 0..n-1){
   for(j in 0..n-1){
     var v = (arr[i][0] and arr2[0][j])
     for(k in 1..n-1){
       v = v or (arr[i][k] and arr2[k][j])
     }
     arr3[i][j] = v
   }
   //bw.write(arr3[i].joinToString()+"\n")
 }
val result = arr3.flatten().count { it == 1 } //배열 평탄화 
bw.write("$result")

 bw.flush()
 bw.close()
}
