package main

//20920
import (
  "bufio"
  "fmt"
  "os"
  "sort"
  //"slices"
)

//Todo. map 이용한 sort 방법이 다른 언어에도 있는지? 그리고 시간이 생각보다 오래걸림. 이유찾기 
func main() {
  //fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  n,m := 0,0 //단어갯수, 단어길이 
  fmt.Fscanln(reader, &n,&m)
  wordMap := make(map[string]int, n)
  //answer:=make([]int,n)
  arr:=make([]string,0)
  i:=0
  for i<n {
    s:=""
    fmt.Fscanln(reader,&s)
    i++
    if len(s) < m {
      continue
    }
    num, ok := wordMap[s]
    if !ok {
        wordMap[s] = 0
    }else {
        wordMap[s] = num+1
    }

  }

  for k:=range wordMap{
    arr=append(arr,k)
  }
  sort.Slice(arr, func(i, j int) bool{
    if wordMap[arr[i]]==wordMap[arr[j]] {
      if len(arr[i])==len(arr[j]) {
        return arr[i]<arr[j]
      }
      return len(arr[i])>len(arr[j])
    }
    return wordMap[arr[i]]>wordMap[arr[j]]
  })


  for _,k := range arr {
    fmt.Fprintln(writer,k)
  }
}
