import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

// 28445
//  첫 번째 줄에 아빠 새의 몸통 색과 꼬리 색이 주어진다.
/*
두 번째 줄에 엄마 새의 몸통 색과 꼬리 색이 주어진다.

각각의 색은 
1자 이상 
20자 이내의 알파벳 소문자로 이루어진 문자열로 주어지며, 같은 색이 중복되어 나타날 수 있다.
*/
// Todo. sortWith, sort, reverse, sortDescending, SortBy
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var s = br.readLine().split(' ') 
    var s2 = br.readLine().split(' ')

    val treeSet = TreeSet<String>().apply {
        addAll(s)
        addAll(s2)
    }
    //bw.write(treeSet.joinToString()+'\n') 

    for(a in treeSet){
        for(b in treeSet){
            bw.write("$a $b\n")
        }
    }

    bw.flush()
    bw.close()
}
