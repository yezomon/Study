package main

//1918
import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	s := ""                 // 식
	fmt.Fscanln(reader, &s) //A*(B+C)
	opstack := make([]string, 0)
	//연산자 우선순위대로 스택에 추가
	//여는 괄호는 스택에 push 닫는괄호 만나면 여는괄호가 나올떄까지 pop하고 괄호는 출력x
	//연산자 우선순위가 더 높으면 스택에 push, 우선순위가 같거나 낮으면 pop해서 출력하고 push
	for i, _ := range s {
		if string(s[i]) == "+" || string(s[i]) == "-" { //연산자 우선순위에 따라 pop
			for len(opstack) > 0 {
				if opstack[len(opstack)-1] != "(" {
					op := opstack[len(opstack)-1]
					opstack = opstack[:len(opstack)-1]
					fmt.Fprint(writer, op)
				} else {
					break
				}
			}
			opstack = append(opstack, string(s[i]))
			// fmt.Fprintln(writer," op",opstack,"+")
			//fmt.Fprintln(writer,string(s[i]),numstack)
		} else if string(s[i]) == "*" || string(s[i]) == "/" { //스택에 그냥 추가..?
			//op := opstack[len(opstack)-1]
			//opstack = opstack[:len(opstack)-1]
			for len(opstack) > 0 { //현재 스택에 본인보다 우선순위가 낮은게 나올때까지 pop
				if opstack[len(opstack)-1] == "*" || opstack[len(opstack)-1] == "/" {
					op := opstack[len(opstack)-1]
					opstack = opstack[:len(opstack)-1]
					fmt.Fprint(writer, op)
				} else { //+ -
					// opstack = append(opstack,string(s[i]))
					//fmt.Println(" op",opstack,"%")
					break
				}
			}
			opstack = append(opstack, string(s[i]))
			//fmt.Println(" op",opstack,"&")
		} else if string(s[i]) == "(" {
			opstack = append(opstack, string(s[i]))
		} else if string(s[i]) == ")" { //괄호 중첩시 생기는 문제..
			//여는 괄호 나올때까지 pop
			for len(opstack) > 0 {
				op := opstack[len(opstack)-1]
				opstack = opstack[:len(opstack)-1]
				if op == "(" {
					break
				}
				fmt.Fprint(writer, op) //
			}
		} else { //피연산자(숫자)
			fmt.Fprint(writer, string(s[i]))

		}
	}
	for range opstack {
		fmt.Fprint(writer, opstack[len(opstack)-1])
		opstack = opstack[:len(opstack)-1]
	}
}