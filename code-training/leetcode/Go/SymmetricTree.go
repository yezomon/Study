/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 /*
     queue := make([] *TreeNode, 0)
    queue = append(queue, root)
    if root.Left == nil && root.Right == nil {
        return true
    }

    for e:=root; len(queue)>1 ; {
        
        if e.Left != nil {
            queue = append(queue, e.Left)
        }
        if e.Right != nil { 
            queue = append(queue, e.Right)
        }
    }
*/
func isSymmetric(root *TreeNode) bool {

    if root.Left == nil && root.Right == nil {
        return true
    }
    arr  := make([] *TreeNode, 0)
    queue := make([] *TreeNode, 0)
    queue = append(queue, root.Left)

    arr2 := make([] *TreeNode, 0)
    queue2 := make([] *TreeNode, 0)
    queue2 = append(queue2, root.Right)
   // fmt.Println(len(queue),len(queue2))

    for e:=root.Left; len(queue)>0 ; {
        e = queue[0]
        queue = queue[1:]
        if e!= nil {
            arr = append(arr,e)
        }else {
            arr = append(arr, nil)
            continue
        }
        // if e.Left == nil && e.Right == nil{
        //     break
        // }
        if e!= nil && e.Left != nil {
            queue = append(queue, e.Left)
        }else {
            queue = append(queue, nil)
        }
        if e!= nil&&e.Right != nil { 
            queue = append(queue, e.Right)
        }else{
            queue = append(queue, nil)
        }
       // fmt.Printf("q %+v %d \n",e,len(arr))
    }

    for e:=root.Right;  len(queue2)>0 ; {
        e = queue2[0]
        queue2 = queue2[1:]
        if e!= nil {
            arr2 = append(arr2,e)
        }else {
             arr2 = append(arr2,nil)
            continue
        }
        if e!= nil && e.Right != nil { 
            queue2 = append(queue2, e.Right)
        }else{
            queue2 = append(queue2, nil)
        }
        if e!= nil && e.Left != nil {
            queue2 = append(queue2, e.Left)
        }else {
            queue2 = append(queue2, nil)
        }

        //fmt.Printf("q2 %+v %d \n",e,len(arr2))
    }
        fmt.Printf("end %d %d \n",len(arr),len(arr2))
    if len(arr) != len(arr2) {
        return false
    }

    for i,_ := range arr{
       // fmt.Printf("w %d %+v %+v  \n",k, arr[i],arr2[i])
        if arr[i]==nil &&arr2[i] !=nil {
            return false
        } 
        if arr2[i]==nil &&arr[i] !=nil {
            return false
        }
        if arr[i]!=nil && arr2[i]!=nil && arr[i].Val != arr2[i].Val {
            return false
        }
    }
    return true
}
