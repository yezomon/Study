type Stack struct{
    v *list.List
}
func NewStack() *Stack{
    return &Stack{list.New()}
}

func (s *Stack)Push(val interface{}){
    s.v.PushBack(val)
}

func (s *Stack)Pop() interface{}{
    back := s.v.Back()
    if back != nil{
        return s.v.Remove(back)
    }
    return nil
}

func isValid(s string) bool {
    //stack := []*TreeNode{}
    stack := NewStack()
    r:= []rune(s)
    if len(r)<2{
        return false
    }
    for i:=0 ;i<len(r) ;i++{
        if r[i] == '(' {
            stack.Push(r[i])
            
        }else if r[i] == '{' {
            stack.Push(r[i])
            
        }else if r[i] == '[' {
            stack.Push(r[i])
            
        }else{ //close
            val := stack.Pop()
            //vv := fmt.Sprintf("%v", val)
            if(val == nil){
                return false
            }
            fmt.Printf("%c",val)
            fmt.Printf("%c",r[i])
            
            if val == '(' && r[i] == ')' {
                continue
            }else if val == '{' && r[i] == '}' {
                continue
            }else if val == '[' && r[i] == ']' {
                continue
            }else{
                fmt.Printf("%c",val)
                fmt.Printf("%c",r[i])
                return false
            }
        }
    }
     val := stack.Pop()
     if(val != nil){
        return false
    }
    return true
}