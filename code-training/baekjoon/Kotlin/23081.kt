import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.*
//with claude
// 23081 

fun main() {
 val br = BufferedReader(InputStreamReader(System.`in`))
 val bw = BufferedWriter(OutputStreamWriter(System.out))
 var n = br.readLine().toInt()
 var arr = Array(n) { Array(n) { "" } }
 for (i in 0..n - 1) {
   var s = br.readLine()
   arr[i] = s.toCharArray().map { it.toString() }.toTypedArray()
 }

 var maxCnt = -1
 var maxX = -1
 var maxY = -1
 var hasValidMove = false

 for (i in 0..n - 1) {
   for (j in 0..n - 1) {
     if (arr[i][j] == ".") {
       var cnt = 0
       var isAnyDirectionValid = false

       // 왼쪽 방향 체크
       var tempCnt = 0
       var isValid = false
       for (k in j - 1 downTo 0) {
         if (arr[i][k] == ".") {
           tempCnt = 0
           break
         } else if (arr[i][k] == "B") {
           isValid = true
           break
         }
         tempCnt++
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       // 오른쪽 방향 체크
       tempCnt = 0
       isValid = false
       for (k in j + 1..n - 1) {
         if (arr[i][k] == ".") {
           tempCnt = 0
           break
         } else if (arr[i][k] == "B") {
           isValid = true
           break
         }
         tempCnt++
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       // 위쪽 방향 체크
       tempCnt = 0
       isValid = false
       for (k in i - 1 downTo 0) {
         if (arr[k][j] == ".") {
           tempCnt = 0
           break
         } else if (arr[k][j] == "B") {
           isValid = true
           break
         }
         tempCnt++
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       // 아래쪽 방향 체크
       tempCnt = 0
       isValid = false
       for (k in i + 1..n - 1) {
         if (arr[k][j] == ".") {
           tempCnt = 0
           break
         } else if (arr[k][j] == "B") {
           isValid = true
           break
         }
         tempCnt++
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       // 우상 대각선
       var r = i - 1
       var c = j + 1
       tempCnt = 0
       isValid = false
       while (r >= 0 && c < n) {
         if (arr[r][c] == ".") {
           tempCnt = 0
           break
         } else if (arr[r][c] == "B") {
           isValid = true
           break
         }
         tempCnt++
         r--
         c++
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       // 좌상 대각선
       r = i - 1
       c = j - 1
       tempCnt = 0
       isValid = false
       while (r >= 0 && c >= 0) {
         if (arr[r][c] == ".") {
           tempCnt = 0
           break
         } else if (arr[r][c] == "B") {
           isValid = true
           break
         }
         tempCnt++
         r--
         c--
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       // 우하 대각선
       r = i + 1
       c = j + 1
       tempCnt = 0
       isValid = false
       while (r < n && c < n) {
         if (arr[r][c] == ".") {
           tempCnt = 0
           break
         } else if (arr[r][c] == "B") {
           isValid = true
           break
         }
         tempCnt++
         r++
         c++
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       // 좌하 대각선
       r = i + 1
       c = j - 1
       tempCnt = 0
       isValid = false
       while (r < n && c >= 0) {
         if (arr[r][c] == ".") {
           tempCnt = 0
           break
         } else if (arr[r][c] == "B") {
           isValid = true
           break
         }
         tempCnt++
         r++
         c--
       }
       if (!isValid) tempCnt = 0
       if (isValid && tempCnt > 0) isAnyDirectionValid = true
       cnt += tempCnt

       if (isAnyDirectionValid && cnt > 0) {
         hasValidMove = true
         if (cnt > maxCnt || 
             (cnt == maxCnt && i < maxY) ||  // y좌표(행) 먼저 비교
             (cnt == maxCnt && i == maxY && j < maxX))  // y좌표가 같을 때 x좌표(열) 비교
         {
           maxCnt = cnt
           maxX = j
           maxY = i
         }
       }
     }
   }
 }

 if (!hasValidMove) {
   bw.write("PASS")
 } else {
   bw.write("$maxX $maxY\n")  // 출력 순서는 x y 순서
   bw.write("$maxCnt")
 }

 bw.flush()
 bw.close()
}
