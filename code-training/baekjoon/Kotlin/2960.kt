// claude made
fun findKthNumber(n: Int, k: Int): Int {
    val numbers = BooleanArray(n + 1) { true }  // 0부터 n까지의 배열 (0과 1은 사용하지 않음)
    var count = 0

    for (i in 2..n) {
        if (numbers[i]) {
            for (j in i..n step i) {
                if (numbers[j]) {
                    numbers[j] = false
                    count++
                    if (count == k) {
                        return j
                    }
                }
            }
        }
    }

    return -1  // K번째 수를 찾지 못한 경우
}

fun main() {
    // 입력 받기
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    // 결과 출력
    val result = findKthNumber(n, k)
    println(result)
}
