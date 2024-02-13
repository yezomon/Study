/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

 //Todo. 메모리20메가에 런타임 157ms 느리고 메모리 많이씀 -> 재귀없이 풀어보기 
 func minDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    answer := recursion(root,0)
    return answer
}

func recursion(node *TreeNode,n int) int {
    //pc:=n //pathcount
    //fmt.Printf("set %+v %d %d \n",node,n,pc) 
    // if node == nil {
    //     fmt.Printf("nil child %+v %d\n",node,n)
    //     return n
    // }
    n++
    if node.Left == nil && node.Right == nil {
        //fmt.Printf("real leaf %+v %d\n",node,n)
        return n
    }
    a,b:=0,0
    if node.Left != nil {
        a=recursion(node.Left,n)
    }
    if node.Right != nil {
        b=recursion(node.Right,n)
    }
    
    //fmt.Printf("%+v %d %d %d %d \n",node,a,b,n,pc) 
    if a==0 && b!=0{
        return b
    }
    if b==0 && a!=0 {
        return a
    }
    if b!=0 && a!=0 && a < b {
        return a 
    }
    return b 
    //return n
}