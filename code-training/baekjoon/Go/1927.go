package main

//1927 시간초과 --> 입출력을 bufio로 변경하고 나서 시간초과해결 
//10431
import (
	"container/heap"
	"fmt"
  "bufio"
  "os"
)

type myHeap []int

func (h *myHeap) Less(i, j int) bool {
  return (*h)[i] < (*h)[j]
}

func (h *myHeap) Swap(i, j int) {
  (*h)[i], (*h)[j] = (*h)[j], (*h)[i]
}

func (h *myHeap) Len() int {
  return len(*h)
}

func (h *myHeap) Pop() (v any) {
  *h, v = (*h)[:h.Len()-1], (*h)[h.Len()-1]
  return
}

func (h *myHeap) Push(v any) {
  *h = append(*h, v.(int))
}
// func (h *IntHeap) Pop() any {
//   old := *h
//   n := len(old)
//   x := old[n-1]
//   *h = old[0 : n-1]
//   return x
// }

func main() {
  h := new(myHeap) //&PriorityQueue{}
	var n int
	var op int
	
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  //fmt.Scanf("%d\n", &n)
  defer writer.Flush()
  fmt.Fscanln(reader,&n)
  //fmt.Fscanln(reader, &a, &b) // 한 줄 입력, 띄어쓰기로 구분 ex) 1 2 => a=1, b=2
  //fmt.Fprintln(writer, a+b)
  //fmt.Fprintln(writer, a-b)
 
	for i := 0; i < n; i++ {
		//fmt.Scanf("%d\n", &op)
    fmt.Fscanln(reader,&op)
		if op == 0 {
			if len(*h) == 0 {
        fmt.Fprintln(writer, 0)
				//fmt.Print("0\n")
				continue
			}
      fmt.Fprintln(writer, heap.Pop(h))
			//fmt.Printf("%d\n", heap.Pop(h)) // 가장작은값출력
		} else {
			heap.Push(h,op) // 입력값을 힙에 넣기
		}
	}
}
