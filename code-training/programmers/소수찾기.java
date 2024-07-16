import java.util.*;
import java.io.*;
//Todo. 만들수있는 모든 경우 찾기  15650  18511
class Solution {
    Set<Integer> ts;
    boolean[] visit = new boolean[7];
    String[] sub = null;
    public int solution(String numbers) {
        int answer = 0;
         sub = numbers.split("");
        ts = new TreeSet<Integer>();
        for(int i =0;i<sub.length;i++){
            //System.out.println(sub[i]);
        }
        recursion(0,"");
        for(Integer i : ts){
            if(isPrime(i)){
                System.out.println(i);
                answer++;
            }
        }
        return answer;
    }
    
    public void recursion(int k ,String s){
        if(k>sub.length){
            return;
        }
        for(int i=0;i<sub.length;i++){
            if(visit[i]) continue;
            visit[i] = true;
            ts.add(Integer.parseInt(s+sub[i]));
            recursion(k+1,s+sub[i]);
            visit[i] = false; //대체왜? -> 각 depth때마다 모든 수를 한번씩은 다써야해서 다음 depth때 쓸려고 ? 
        }
        
    }
    
    boolean isPrime(int N) {
    if (N < 2) return false;
     for (int j=2 ; j<=N/2; j++){ //j=2*i 최적화 { //(i < 루트 N) 은 (i*i < N) 으로 표현
    	if (N%j == 0) return false;
    }
    return true;
    }
}