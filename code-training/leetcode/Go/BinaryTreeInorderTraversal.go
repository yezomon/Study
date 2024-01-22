/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 //inorder - 방문 L T R 
 //preorder T L R 
 //postorder L R T 
 // 
 func inorder(node *TreeNode, a []int) []int {
    //fmt.Println(node.Val,a,n); 
    if node == nil {
        fmt.Println("/")
        return a
    }
    a=inorder(node.Left,a)
    a=append(a,node.Val)
    fmt.Println("/",node.Val,a); 
    //nn++
    a=inorder(node.Right,a)
    return a
}
//TODO. 재귀없이 트리순회 구현하기 
func inorderTraversal(root *TreeNode) []int {
    answer := make([]int, 1)
    if root == nil {
        return nil
    }
    // if root.Left == nil && root.Right == nil {
    //     return nil
    // }
    answer = inorder(root, answer)
    return answer[1:]
}