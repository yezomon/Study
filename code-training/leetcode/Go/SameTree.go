/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func isSameTree(p *TreeNode, q *TreeNode) bool {
    queue := make([]*TreeNode,0)
    queue2 := make([]*TreeNode,0)
    
    queue = append(queue, p)
    queue2 = append(queue2, q)
    fmt.Println(p,q,"start")

    if q == nil && p!= nil { //xor?
        return  false
    }else if q != nil && p == nil{
         return  false
    }else if q == nil && p== nil {
          return  true
    }

    for e,k:=p,q;  len(queue) > 0 && len(queue2) > 0 ; { //len(queue) > 0 && len(queue2) > 0
        e,k=queue[0],queue2[0]
        queue = queue[1:]
        queue2 = queue2[1:]
        fmt.Println(e,k)
        // if e== nil && k== nil {
        //     continue
        // }
        if e == nil && k!= nil { //xor?
            return  false
        }else if e != nil && k== nil{
            return  false
        }

        if e!=nil && k!=nil && e.Val != k.Val {
            return false
        }
        if  e!=nil && k!=nil && e.Left!=nil && k.Left!=nil && e.Left.Val != k.Left.Val {
            return false
        }
        if  e!=nil && k!=nil && e.Right!=nil&&k.Right!=nil && e.Right.Val != k.Right.Val {
            return false
        }
        if  (e!=nil &&  k!=nil && e.Right == nil && k.Right != nil)||(e!=nil &&  k!=nil && e.Right != nil && k.Right == nil){
            return  false
        }else if (e!=nil && k!=nil &&e.Left != nil && k.Left == nil)||(e!=nil && k!=nil &&e.Left == nil && k.Left != nil){
            return  false
        }

        if e!=nil {
            queue = append(queue, e.Left)
            queue = append(queue, e.Right)
        }
        if k!=nil {
            queue2 = append(queue2, k.Left)
            queue2 = append(queue2, k.Right)
        }
        fmt.Println(queue,queue2,len(queue),len(queue2))
        // if e!= nil && k!= nil {
        //     if e.Left == nil &&  k.Left == nil &&  e.Right == nil &&  e.Right == nil {
        //         break
        //     }
        // }
    }
    return true
}