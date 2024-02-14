//abcdef
//a ab abc abcd abcdef
//b bc bcd bcde bcdef
//c cd cde cdef 
//d de def 
//e ef
//f
//시간초과 이슈 --> 현재 찾아낸 문자열 길이 보다 작은건 거르고 다음 차례를 시작하면? 
func lengthOfLongestSubstring(s string) int {
    answer := 0 
    var substring string
    for i,_ := range s{
        for j:=i;j<len(s)+1;j++{
            substring = s[i:j]//s[:len(s)]
            if len(substring) < 1 {continue}
             ss := substring[len(substring)-1:]//strings.Split(substring,"") //마지막글자 
            // fmt.Println(substring,i,j,ss,len(ss))
            //if len(ss) <= j {continue}
            if strings.Contains(substring[:len(substring)-1], ss) { //마지막글자가 현재문자열에서 중복인가
                fmt.Println("중복",substring)
                break
             }else{
                 if answer < len(substring){
                     answer = len(substring)
                 }
                
             }
        }
        
       
    }
    fmt.Println("substring,i,k")
    return answer
}