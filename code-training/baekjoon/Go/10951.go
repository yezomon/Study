package main

//10951
import (
	"bufio"
	"fmt"
	"os"
  //"io"
	"strconv"
	"strings"
)

// 조건 :
/*

*/
//Todo.
func main() {
	//fmt.Println("Hello, World!")
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  //var sc = bufio.NewScanner(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	//n, m := "", ""
  for{
    input, err := reader.ReadString('\n')
    if err != nil {
      //fmt.Println("Error reading input:", err)
      return
    }
    // Check for EOF
    if err == bufio.ErrBufferFull {
      //fmt.Println("Reached EOF")
      return
    }
    // Trim whitespace from the input
    input = strings.TrimSpace(input)

    // Split input into two strings using whitespace as the delimiter
    inputs := strings.Split(input, " ")
    if len(inputs) != 2 {
      //fmt.Println("Please enter two integers separated by whitespace.")
      return
    }
    n, err := strconv.Atoi(inputs[0])
    if err != nil {
      //fmt.Println("Error parsing integer:", err)
      return
    }

    m, err := strconv.Atoi(inputs[1])
    if err != nil {
      //fmt.Println("Error parsing integer:", err)
      return
    }
    fmt.Fprintln(writer,n+m)
  }

	//fmt.Fscan(reader, &m)

	//fmt.Fprintln(writer, n/m)//m*(n-1)+(m-1)*n)
	//fmt.Fprint(writer, n%m)
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
