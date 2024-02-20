//부분문자열 전체를 뒤집으니까 시간초과나는거같기도
//미디엄 40분안에 풀기 fail 
func longestPalindrome(s string) string {
    var answer string
    max := 0
    skip := false
    for i:=0;i<len(s);i++{
        skip = false
        for j:=i;j<len(s)+1;j++{
            if (j-i) < max {continue}
            ss := s[i:j]
            if len(ss) < 1 {continue}
            
            //fmt.Println(i,j,ss)
            var rss string

            for x:=0;x<len(ss)/2;x++{
                if ss[x] != ss[len(ss)-x-1] {
                    skip = true
                    break
                }
            }
            if skip {
                skip = false
                continue
            }

            for _, v:= range ss{
                rss = string(v) + rss 
            }

            if rss == ss {
                fmt.Println(max,"Palindrome:",rss)
                if (max < len(rss)){
                    answer = rss
                    max = len(rss)
                }
            }
        }
    }

    return answer 
}