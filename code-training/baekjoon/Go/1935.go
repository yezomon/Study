package main

//1935
import (
  "bufio"
  "fmt"
  "os"
  "strconv"
  //"slices"
)

//Todo. 문자열 ss생성하는 부분이 필요없는것같음. 제거 필요 
func main() {
  //fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
  n,s := 0,"" //피연산자갯수 , 식  
  fmt.Fscanln(reader, &n)
  fmt.Fscanln(reader, &s) // ABC*+DE/-
  //var answer int64
  //answer:=make([]int,n)
  ss:=""
  numstack:=make([]float64,0)
 // opstack:=make([]int,0)
  numMap:=make(map[string]int)
  for i,_:=range s{
    num:=0
    if s[i]=='+'||s[i]=='-'||s[i]=='*'|| s[i] == '/'{
      ss+=string(s[i])
      continue
    } else {
      k, ok := numMap[string(s[i])]
      if ok {
        ss+=strconv.Itoa(k)
         continue
      }
      fmt.Fscanln(reader,&num)
      numMap[string(s[i])]=num
      ss+=strconv.Itoa(num) //근데 두자리수자는 어떻게되는건지? 
    }
  }

  for i,_:=range s{ 
    if s[i]=='+'||s[i]=='-'||s[i]=='*'|| s[i] == '/' {
      n1 := float64(numstack[len(numstack)-1])
      numstack = numstack[:len(numstack)-1]
      n2 := float64(numstack[len(numstack)-1])
      numstack = numstack[:len(numstack)-1]
      numstack = append(numstack, cal(string(s[i]),n1,n2))
      //fmt.Fprintln(writer,string(s[i]),numstack)
    }else {
      numstack=append(numstack,float64(numMap[string(s[i])]))
      //fmt.Fprintln(writer,numstack)
    }
  }  
  
   fmt.Printf("%.2f",numstack[0])
    // si,err := strconv.ParseInt(s[i],64)
    // if err != nil {
    //   continue
    // }
    // fmt.Fprintln(writer,numstack,opstack)) 
}

func cal(op string, n1,n2 float64) float64 {
  switch op {
    case "+":
      return n1+n2
    case "-":
      return n2-n1
    case "*":
      return n1*n2
    case "/":
      return n2/n1
  }
  return 0
}
