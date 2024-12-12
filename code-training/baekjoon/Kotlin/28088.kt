
// claude make. 
fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    var current = BooleanArray(n)

    // 1단계 초기화
    repeat(m) {
        current[readln().toInt()] = true
    }

    if (k == 0) {
        // 현재 상태(1단계)가 마지막 상태이므로 바로 다음 단계 계산
        println(current.count { it })
        return
    }

    // k가 0이 아닌 경우 시뮬레이션 진행
    repeat(k-1) {
        val next = BooleanArray(n)
        val leftHear = BooleanArray(n)
        val rightHear = BooleanArray(n)

        for(i in 0 until n) {
            if(current[i]) {
                val left = (i - 1 + n) % n
                val right = (i + 1) % n
                rightHear[left] = true
                leftHear[right] = true
            }
        }

        for(i in 0 until n) {
            next[i] = (leftHear[i] xor rightHear[i]) // XOR은 두 값이 서로 다를 때만 true를 반환하는 논리 연산
        }

        current = next
    }

    // k단계 이후의 응애 가능한 사람 수 계산
    val leftHear = BooleanArray(n)
    val rightHear = BooleanArray(n)

    for(i in 0 until n) {
        if(current[i]) {
            val left = (i - 1 + n) % n //(i - 1 + n) % n에서 +n을 하는 이유는 음수가 되는 것을 방지하기 위함
            val right = (i + 1) % n
            rightHear[left] = true
            leftHear[right] = true
        }
    }

    println((0 until n).count { leftHear[it] xor rightHear[it] })
}
