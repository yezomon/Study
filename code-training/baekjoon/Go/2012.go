package main

//2012
import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
)

func main() {
	//fmt.Println("Hello, World!")
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	n := 0
	fmt.Fscanln(reader, &n)
	arr := make([]int, n)

	//n 50만
	//등수는 1~n까지의 등수 , 동점없이 등수를 매겨야함
	//가장 큰 불만도 : 모든 학생이 1등을 주장
	//가장 작은 불만도 : 모두 원하는 등수  (순차증가)
	//최악의 경우 n+n-1+n-2... 모든 등수에 대해 각 학생중 가장 차가 적은 것을 배정 하려면 n개의 등수에 n-1번 비교 (이미p 등수를 받은 학생 제외라서 n-1) => 이방식은 오답. 이러면 그 다음에 올 학생이 어떤 등수를 제시했는지에 따라 불만도가 달라지기때문에 자기 차례일때 이 불만도가 최선인지 알수없음..
	//다시 생각한 최악의경우 : 5개의 숫자를 나열하는 경우의수 : n! 각 경우에 대해 불만도를 모두 계산해서 최저값을 비교 --> 시간이 말도안되게 걸림  모든 경우의 수말고 줄일방법 : 숫자를 정렬해서 앞에서부터 등수매기기..?
	//5 15312   -> 실제 등수 15423 불만도3 15324 불만도3 15432 불만도3

	for i, _ := range arr {
		fmt.Fscanln(reader, &arr[i])
	}

	sort.Ints(arr)
	total := 0
	for i, _ := range arr {
		total += int(math.Abs(float64(arr[i] - (i + 1))))
	}
	fmt.Fprintln(writer, total)
	// fmt.Fprintln(writer, arr)
	// m := make(map[int]int)
	// for j := 0; j < n; j++ {
	// 	diff := n
	// 	idx := -1
	// 	for i, _ := range arr {
	// 		_, ok := m[i]
	// 		if ok {
	// 			continue
	// 		}
	// 		d := int(math.Abs(float64(arr[i] - (j + 1))))
	// 		fmt.Fprintln(writer, d, "d", j)
	// 		if d < diff {
	// 			diff = d
	// 			idx = i
	// 		}
	// 	}
	// 	m[idx] = diff
	// 	arr[idx] = (j + 1)
	// }

	//runes1 := []rune(s1)
	/*sort.Slice(runes,func(i, j int) bool {
	  return runes[i]<runes[j]
	})*/

	//fmt.Fprint(writer,strings.Count(s1,s2))
	//반례
	/*

	 */
	// fmt.Println(string(runes))
}
