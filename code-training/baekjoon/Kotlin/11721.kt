fun main() {
    val word = readLine()!!
    for (i in word.indices step 10) {
        println(word.substring(i, minOf(i + 10, word.length)))
    }
}
