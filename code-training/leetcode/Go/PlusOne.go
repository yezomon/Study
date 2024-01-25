//큰수더하기 
func plusOne(digits []int) []int {
    answer := make([]int, len(digits)+1)
    // for index, _ := range answer {
    //     answer[len(answer)-1-index] = 0
    //     fmt.Println(answer)
    // // index is the index where we are
    // // element is the element from someSlice for where we are
    // }

//999 + 0001  1000
//결과의 자릿수를 아직 모르니까 일단 뒤집기 -> 그냥 리스트를 쓸까 
// for i, j := 0, len(a)-1; i < j; i, j = i+1, j-1 {
//     a[i], a[j] = a[j], a[i]
// }

//num := digits[len(digits)-1] + 1
    answer[len(answer)-1] = 1
     fmt.Println(answer)
    for i:=len(answer)-1 ; i>0; i-- { 
        tmp := answer[i] + digits[i-1]
        answer[i] = tmp % 10
        answer[i-1] = answer [i-1] + (tmp / 10)
        fmt.Println(answer)
    }

    if answer[0] == 0 {
        //n_answer := make([]int, len(digits))
        //copy (nanswer[:], answer[1:])
        return answer[1:]
    }

    return answer
}