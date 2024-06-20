import java.util.*;
import java.io.*;
class Solution {
    boolean[] visit;
    List<Integer> ts = new LinkedList<Integer>();//Set<Integer> ts = new TreeSet<Integer>();
    int[] numbersCopy;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        numbersCopy = Arrays.copyOf(numbers,numbers.length);//numbers;
        visit = new boolean[numbers.length];
        //System.out.println(String.valueOf(numbersCopy.length));
        recursion(0,0,0);
        for(Integer i : ts){
            //System.out.println(String.valueOf(i));
            if(i==target){
                answer++;
            }
        }
        return answer;
    }
    
     public void recursion(int idx ,int sum,int depth){
       
        if(depth>=numbersCopy.length){
             //System.out.println(String.valueOf(sum));
            ts.add(sum);
            return;
        }
        recursion(idx+1,sum+numbersCopy[idx],depth+1);
        recursion(idx+1,sum-numbersCopy[idx],depth+1);
        // for(int i=idx;i<visit.length;i++){ //this is 시간초과 
        //     if(visit[i]) continue;
        //     visit[i] = true;
        //     recursion(idx+1,sum+numbersCopy[i],depth+1);
        //     recursion(idx+1,sum-numbersCopy[i],depth+1);
        //     visit[i] = false; //이건대체왜..
        // }
        
    }
}