func isPalindrome(x int) bool {
    //(think) 문자열로 전환하지 않고 푸는법?? 
    s := strconv.Itoa(x)
    r := []rune(s)
    for i:= 0 ; i < len(r) ; i++ {
        fmt.Println(r[i])
        if r[i] != r[len(r)-i-1] {
            return false;
        }
    }

    return true;
}