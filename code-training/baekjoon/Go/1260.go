package main
//1260
import (
  "fmt"
  "bufio"
  "os"
  "sort"
)
//DFS BFS
func main() {
  //fmt.Println("Hello, World!")
  var reader *bufio.Reader = bufio.NewReader(os.Stdin)
  var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
  defer writer.Flush()
 // a,b,c := 0,0,0
  n,m,v:=0,0,0 //정점 간선 시작정점 
  fmt.Fscanln(reader,&n,&m,&v)
  visited:=make([]bool,n)// 정점 : index+1 = 정점번호 디폴트 false
  dfs:=make([]int,0)
  bfs:=make([]int,0)
  g:=make(map[int][]int)//간선 
  i:=1
  for i <= m {
    v1,v2:=0,0
    //g[i-1]=make([]int,2)
    fmt.Fscanln(reader,&v1,&v2)
    g[v1]=append(g[v1],v2)
    g[v2]=append(g[v2],v1)
    //g[i-1][0],g[i-1][1]=v1,v2
    i++
  }

  for m:=range g {
    sort.Ints(g[m])
    // for n:=range g[m] {
    //   fmt.Fprintln(writer,m,g[m][n],"mm")
    // }
  }
  //BFS
  queue:=make([]int,0)
  queue = append(queue, v)
  queue[0]=v
  for ;len(queue) > 0;{
    q:=queue[0]
    queue=queue[1:]
    //fmt.Fprintln(writer,"q",queue)
    if visited[q-1] {
      //fmt.Fprintln(writer,"visited",q,queue,visited)
      continue
    }
    visited[q-1]=true
    for _,m:=range g[q]{
      queue = append(queue,m)
      //fmt.Fprintln(writer,q,g[q],m,queue)
    }
    //fmt.Fprintln(writer,q,"qq",queue)
    bfs = append(bfs, q)
  }

  for m:=range g {
    sort.Sort(sort.Reverse(sort.IntSlice(g[m])))//sort.Ints(g[m])
    // for n:=range g[m] {
    //   fmt.Fprintln(writer,m,g[m][n],"mm")
    // }
  }
  //fmt.Fprintln(writer,g,visited)
  visited = make([]bool, n)
  //DFS
  stack:=make([]int,0)
  stack = append(stack, v)
  stack[0]=v
  for ;len(stack) > 0;{
    s:=stack[len(stack)-1]
    stack=stack[:len(stack)-1]
    if visited[s-1] {
      //fmt.Fprintln(writer,"visited",s,stack,visited)
      continue
    }
    visited[s-1]=true
    //k1,k2,i:=g[s],0,1
    for _,m:=range g[s]{
      stack = append(stack,m)
      //fmt.Fprintln(writer,s,g[s],m,stack)
    }
    //fmt.Fprintln(writer,s,"st",stack)
    dfs = append(dfs, s)
    // if !visited[s-1]{
    //   visited[s-1]=true
    //   stack = append(stack, )
    // }
  }
  for i,k := range dfs {
    fmt.Fprint(writer,k)
    if i != len(dfs)-1 {
      fmt.Fprint(writer," ")
    }
  }
  fmt.Fprintln(writer)
  for i,k := range bfs {
    fmt.Fprint(writer,k)
    if i != len(bfs)-1 {
      fmt.Fprint(writer," ")
    }
  }

  //results := make([]int,max)
  //fmt.Fprintln(writer, arr) //F빼먹었을때 이상하게 나오던데 뭘까? 
  //fmt.Fscan(reader, &a, &b, &c)
  //fmt.Fscanln(reader,&N)
  // for {
  //   fmt.Fscanln(reader,&a,&b,&c)
  //   if a==0 && b==0 && c==0 {
  //     break
  //   }
  // }
  // fmt.Fprintln(writer,a1*a2)
}
