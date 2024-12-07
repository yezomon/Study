import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
import kotlin.code 

// 31458
// Todo. sortWith, sort, reverse, sortDescending, SortBy

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt() 
    for (i in 0..n-1) {
        var s = br.readLine()
        var ix = if (s.indexOf("0")>s.indexOf("1")) s.indexOf("0") else s.indexOf("1")
        var num = s[ix].code -'0'.code
        var fac = s.length - ix-1
        var rev = s.length - fac-1
        //bw.write("$ix $num $rev $fac \n")
        //array[i] = s.map{it.toString()}.toTypedArray() //s.map { it.toInt() }.toIntArray()
        if(fac>0){
          num = 1
        }
        //rev 가 홀수면 반전 짝수면 그대로. 
        if(rev>0 && rev%2!=0){
          num = 1 - num
        }
        bw.write("$num\n")
    }
   
    bw.flush()
    bw.close()
}
