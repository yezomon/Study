package main

//1212
import (
	"bufio"
	"fmt"
	"os"
	// "sort"
)

// 문자열로 하니까 메모리초과 발생...
func main() {
	//fmt.Println("Hello, World!")
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	s := ""
	fmt.Fscanln(reader, &s) //수의 길이 333,334
	//fmt.Fprintln(writer,len(s))
	//r:=[]rune(s)
	//arr := make([]int, len(r)*3+2)

	//ss := ""
	for i := 0; i < len(s); i++ {
		//fmt.Fprintln(writer, s[i:i+3])
		if s[i:i+1] == "0" {
			//ss += "000"
			if i == 0 {
				fmt.Fprint(writer, "0")
			} else {
				fmt.Fprint(writer, "000")
			}
		} else if s[i:i+1] == "1" {
			//	ss += "001"
			if i == 0 {
				fmt.Fprint(writer, "1")
			} else {
				fmt.Fprint(writer, "001")
			}
		} else if s[i:i+1] == "2" {
			//ss += "010"
			if i == 0 {
				fmt.Fprint(writer, "10")
			} else {
				fmt.Fprint(writer, "010")
			}
		} else if s[i:i+1] == "3" {
			//ss += "011"
			if i == 0 {
				fmt.Fprint(writer, "11")
			} else {
				fmt.Fprint(writer, "011")
			}
		} else if s[i:i+1] == "4" {
			//ss += "100"
			fmt.Fprint(writer, "100")
		} else if s[i:i+1] == "5" {
			//ss += "101"
			fmt.Fprint(writer, "101")
		} else if s[i:i+1] == "6" {
			//ss += "110"
			fmt.Fprint(writer, "110")
		} else if s[i:i+1] == "7" {
			//ss += "111"
			fmt.Fprint(writer, "111")
		}
	}

	//runes1 := []rune(s1)
	/*sort.Slice(runes,func(i, j int) bool {
	  return runes[i]<runes[j]
	})*/

	//fmt.Fprint(writer,strings.Count(s1,s2))
	//반례
	/*
				  # 반례
				# 입력
				111111111111111111111111111111111111111111111111111111
				# 출력
				-1633477519
				# 정답
				777777777777777777

		    #반례
		    입력
		    10
		    정답
		    1000
	*/
	// fmt.Println(string(runes))
}
