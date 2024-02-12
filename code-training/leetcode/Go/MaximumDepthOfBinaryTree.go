/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 //DFS
 func maxDepth(root *TreeNode) int {
    if root == nil {
        return 0 
    }
    if root.Left == nil && root.Right == nil {
        return 1
    }
    a := recursion(root,0)
    //fmt.Printf("RCV %d  \n", a)
    
    return a
}

func recursion(node *TreeNode, n int) int{
    an := n 
    if node == nil {
        return an
    }
    an++
    a:=recursion(node.Left,an)
    b:=recursion(node.Right,an)
    //fmt.Printf("RCV %d %d %+v %d %d\n", n, an, node,a,b)
    if a < b {
        return b
    }
    return a 
}
 /**
         e=queue[len(queue)-1]
        queue[len(queue)-1] = nil // or the zero value of T
        queue = queue[:len(queue)-1]
        
        if e == nil {
            fmt.Println(e,"cq:",queue)
            // if len(queue) != 0 {
            //     answer ++ 
            // }
           // queue = append(queue, e)
            continue
        }
        if e.Left != nil  {
           //answer++
           queue = append(queue, e.Left)
        }
        if e.Right != nil  {
           //answer++
            queue = append(queue, e.Right)
        }
        if e.Left != nil && e.Right != nil {
            //answer--
            //double ++ 
            fmt.Println("LR")
            //continue
        }
        if e.Left != nil || e.Right != nil {
            answer ++
        }
        
        fmt.Println(answer,e,"q:",queue, len(queue))
        if maxqueue < len(queue) {
           // maxqueue = len(queue)
        }
 */
 /*
     queue := make([]*TreeNode, 0)
    queue = append(queue, root)
    stack := make([]*TreeNode, 0)
    stack = append(stack, root)
    
    //answer := 1
    prevq := 0
    maxs:= 0
    //visit:=1
    if root == nil {
        return 0 
    }
    if root.Left == nil && root.Right == nil {
        return 1
    }
     for e:=root;  len(stack) > 0  ; { 
         //k=queue[len(queue)-visit]
        e=stack[len(stack)-1]
        stack[len(stack)-1] = nil // or the zero value of T
        stack = stack[:len(stack)-1]

        fmt.Printf("e st %+v %+v %d %d \n",e,len(stack), maxs, prevq)
        //queue[len(queue)-1] = nil // or the zero value of T
        //queue = queue[:len(queue)-1]
        if e == nil {
            fmt.Printf("e nil? %+v %v\n",e,stack)
            //visit++
        }
        if e.Left != nil  {
            queue = append(queue, e.Left)
            stack = append(stack, e.Left)
           
        }else {
            //queue = append(queue, nil)
        }
        if e.Right != nil  {
            queue = append(queue, e.Right)
            stack = append(stack, e.Right)
           
        }else {
            //queue = append(queue, nil)
        }
        maxs++
        if e!=nil && e.Left == nil && e.Right == nil {
            fmt.Println("leaf")
            if prevq < maxs {
                // maxqueue = len(queue)
                prevq = maxs
                fmt.Printf("pm %d %+v %+v \n",len(stack), maxs, prevq)
            }
            maxs = 0
        }
        
        if prevq < len(stack) {
           // maxqueue = len(queue)
           //prevq = len(stack)
           //visit++
          // fmt.Printf("pq %d %+v %+v \n",len(stack),len(queue), prevq)
        }
    }
    fmt.Printf("end %d %+v %+v %d\n",len(stack),len(queue), prevq, maxs)

    return len(queue)/2
 */