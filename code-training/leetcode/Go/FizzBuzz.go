func fizzBuzz(n int) []string {
    answer:= make([]string, n)
    
    for i,_ := range answer {
        if (i+1)%3==0 && (i+1)%5==0 {
            answer[i] = "FizzBuzz"
        } else if ((i+1)%3 == 0) {
            answer[i] = "Fizz"
        } else if ((i+1)%5 == 0) {
            answer[i] = "Buzz"
        }else{
            answer[i] = strconv.Itoa(i+1)
        }
        i++
    }

    return answer
}