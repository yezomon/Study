/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    //v:= list.New()
    if list1 == nil && list2 == nil{
        return nil
    }
    answer := &ListNode{0,nil}
    c:= answer
   
    for t1, t2 := list1, list2; t1!= nil || t2 != nil;  {
        if t1 == nil {
            c.Val = t2.Val
            t2 = t2.Next
            if t2 != nil {
                c.Next = &ListNode{0,nil}
            }

            c = c.Next
            continue           
        }
        if t2 == nil {
            c.Val = t1.Val
            t1 = t1.Next
            if t1 != nil {
                c.Next = &ListNode{0,nil}
            }
            c = c.Next
            continue           
        }

        if t1.Val < t2.Val {
            c.Val = t1.Val
            t1 = t1.Next //last nil
        }else{ // same or reverse
            c.Val = t2.Val
            t2 = t2.Next //last nil 
        }
        fmt.Print(c.Val,"");
        c.Next = &ListNode{0,nil}
        c = c.Next
        //v.PushBack(e.Val)
    }

    return answer
}