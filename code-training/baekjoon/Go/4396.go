package main

//4396
import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

// 조건 :
/*
//
// Todo.
// 첫n줄 * - 지뢰위치 . - 지뢰없는 곳
//둘n줄 x - 열린칸  . -안열린칸
//열린칸에 지뢰숫자넣기  안열린칸 . 지뢰 *
*/
func main() {
	//fmt.Println("Hello, World!")
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	n := 0
	x := ""
	fmt.Fscanln(reader, &n)
	ans := make([][]string, n+2)
	arr := make([][]string, n+2)
	arr2 := make([][]string, n+2)

	for i := 0; i < n+2; i++ {
		ans[i] = make([]string, n+2)
		arr[i] = make([]string, n+2)
		arr2[i] = make([]string, n+2)
	}

	for i := 1; i < n+1; i++ {
		fmt.Fscanln(reader, &x)
		for j := 1; j < n+1; j++ {
			arr[i][j] = string(x[j-1])
		}
	}

	for i := 1; i < n+1; i++ {
		fmt.Fscanln(reader, &x)
		for j := 1; j < n+1; j++ {
			arr2[i][j] = string(x[j-1])
		}
	}
  /*
  for i := 0; i < n+2; i++ { //
    fmt.Fprintln(writer, arr[i])
  }
	fmt.Fprintln(writer, "Hello") //
  for i := 1; i < n+1; i++ { //
    fmt.Fprintln(writer, arr2[i])
  }*/

  bombIs := false
	for i := 1; i < n+1; i++ {
		for j := 1; j < n+1; j++ {
			if arr[i][j] == "*" && arr2[i][j] == "x" { //지뢰있고 열림 - 모든 지뢰 오픈
        bombIs = true
			}
			if arr[i][j] == "." && arr2[i][j] == "x" { //지뢰없고 열림 - 숫자표시
				s := arr[i-1][j-1] + arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j] 
        // map[x - 1, y - 1] + map[x, y - 1] + map[x + 1, y - 1] + map[x + 1, y] + map[x + 1, y + 1] + map[x, y + 1] + map[x - 1, y + 1] + map[x - 1, y];
				ans[i][j] = strconv.Itoa(strings.Count(s, "*"))
			}
			if arr2[i][j] == "." { //안열림
        ans[i][j] = "."
			}
		}
	}
  for i := 1; i < n+1; i++ {
    for j := 1; j < n+1; j++ {
      if bombIs == true && arr[i][j] == "*" {
        ans[i][j] = "*"
      }
    }
  }
  for i := 1; i < n+1; i++ {
    for j := 1; j < n+1; j++ {
      fmt.Fprint(writer, ans[i][j])
    }
    fmt.Fprintln(writer, "")
  }


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
