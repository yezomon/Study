package main

//1978소수찾기
import (
	"bufio"
	"fmt"
	"os"
	//"strconv"
	//"strings"
)

// 조건 :
/*
// N개의 수 N<=100 
// 수의범위 1000 이하 
// max : 100개가 각각 900이상의 수라면 완전탐색일때 100 * 1000 번..? 
// 1은 소수가 아닌듯하다.
// 소수는 1과 자기자신으로만 나누어지는 수
*/
//Todo.  https://maramarathon.tistory.com/39
func main() {
	//fmt.Println("Hello, World!")
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	n := 0
	fmt.Fscanln(reader, &n)
	ans := make([]int, n)
  answer := 0 //소수갯수 
	for i := 0; i < n; i++ {
    fmt.Fscan(reader, &ans[i])
	}
  for _, v := range ans {
    if v == 1 {
      continue
    }
    if v == 2{
      answer++
      continue
    }
    for j := 2; j < v; j++ {
      if v % j == 0 {
        break
      }
      if j == v-1 {
        answer++
      }
    }
  }
  
  fmt.Fprint(writer, answer)
	/*
	  for {
	    if strings.Contains(strconv.Itoa(j),string(s[i])) { // 00000일때 100 200 300 등
	      fmt.Fprintln(writer,i,"//",string(s[i]), "*",j)
	      if i==(len(s)-1){
	         break
	      }
	      i++
	    }
	    j++
	  }
	*/
	//fmt.Fprint(writer, strings.Count(s,"1"))
	//runes1 := []rune(s1)
	/*sort.Slice(runes,func(i, j int) bool {
	  return runes[i]<runes[j]
	})*/

	//fmt.Fprint(writer,strings.Count(s1,s2))
	//반례
	/*
	   100000
	   Answer:1048576
	   Output:1
	*/
	// fmt.Println(string(runes))
}
