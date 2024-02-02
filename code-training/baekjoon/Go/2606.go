package main

import (
	"fmt"
)

// 2606
// DFS인데 재귀로 푸는방법도 생각해보면? 
//
	//fmt.Printf("%d\n" )
	/*for i := 0; i < numberOfComputer; i++ {
		fmt.Printf("%d\n", vertices[i])
	}*/
	//최대 커넥션은 n-1 + n-2 + n-3 + ... + 1 (중복연결은 안들어오나봐??) 이거공식뭐더라
	//그래프에서의 DFS??
	// 1-4 -> 4를 찾음 -> 4에 연결된 애들 다찾음 -> 걔네한테 연결된 애들 다찾음 재귀?->끝은? 끝을 어케찾을지가 문제네 ->visited 배열로 해결
func main() {
	var numberOfComputer int
	var numberOfConnection int
	fmt.Scanf("%d", &numberOfComputer)
	fmt.Scanf("%d", &numberOfConnection)
	vertices := make([][]int, numberOfComputer)
	answer := make([]int, numberOfComputer) //visited 

	if numberOfComputer <= 1 || numberOfConnection <= 0 {
		fmt.Println(0)
		return
	}
	//fmt.Println(len(vertices))
	for i := range vertices {
		vertices[i] = make([]int, numberOfComputer)
	}
	//fmt.Println(len(vertices[0]))

	for i := 0; i < numberOfConnection; i++ {
		a, b := 0, 0
		fmt.Scanf("%d %d", &a, &b)
		vertices[a-1][b-1] = 1
		vertices[b-1][a-1] = 1 //
	}

	stack := make([]int, 0)
	stack = append(stack, 0)
	for i, e := 0, 0; i < numberOfComputer && len(stack) > 0; { //i<numberOfConnection
		//fmt.Printf("%d !!%+v\n", i, stack)
		e = stack[0]
		stack = stack[1:]
		for j := 0; j < numberOfComputer; j++ {
			if vertices[e][j] == 1 {
				if answer[j] != 1 {
					stack = append(stack, j)
					answer[j] = 1
					//fmt.Printf("%d %d * %d\n", j, j+1, e+1)
					i++
				}
			}
		}
		//	fmt.Printf("?%+v\n", stack)
	}

	numberOfAnswer := 0
	for i, _ := range answer {
		if answer[i] == 1 {
			numberOfAnswer++
		}
	}
	//fmt.Println(answer)
	if numberOfAnswer == 0 {
		fmt.Printf("%d\n", numberOfAnswer)
		return
	}
	fmt.Printf("%d\n", numberOfAnswer-1) //1번본인 제외
}
