import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    
    // 점수 입력 받기
    val scores = mutableListOf<Int>()
    repeat(5) {
        val score = reader.readLine().toInt()
        // 40점 미만은 40점으로 처리
        scores.add(if (score < 40) 40 else score)
    }
    
    // 평균 계산
    val average = scores.average().toInt()
    
    // 결과 출력
    println(average)
}
