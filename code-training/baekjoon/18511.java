// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Test;
// public class Main {
//   public static void main(String[] args) {
//     System.out.println("Hello world!");
//   }

//   // @Test
//   // void addition() {
//   //     assertEquals(2, 1 + 1);
//   // }
// }
//array copy 
import java.io.*;
import java.util.*;
//18511
// 첫째 줄에 N, K의 원소의 개수가 공백을 기준으로 구분되어 자연수로 주어진다. (10 ≤ N ≤ 100,000,000, 1 ≤ K의 원소의 개수 ≤ 3) 둘째 줄에 K의 원소들이 공백을 기준으로 구분되어 주어진다. 각 원소는 1부터 9까지의 자연수다.
// https://www.acmicpc.net/board/view/97752
// https://www.acmicpc.net/board/view/139408
// https://www.acmicpc.net/board/view/72420
// https://koder0205.tistory.com/351
// https://passionfruit200.tistory.com/412
// https://velog.io/@99mon/BOJ-18511-%ED%81%B0-%EC%88%98-%EA%B5%AC%EC%84%B1%ED%95%98%EA%B8%B0

public class Main {
  // static int[] dp;
   static int[] arr;
  public static void main(String[] args) throws Exception {
    // Input & Output stream
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;
    //int num = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    st = new StringTokenizer(br.readLine());
    //ArrayList<Integer> arr = new ArrayList<Integer>();
    arr = new int[k];
    for(int i = 0;i<k;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    //완탐 dp 
    int ans = recursion(0,num);
    bw.write(String.valueOf(ans));
    /* ArrayList<Integer> list = new ArrayList<Integer>();
     int max = Integer.MIN_VALUE;
    for (int i = 0; i < num; i++) {
      // st = new StringTokenizer(br.readLine());
      list.add(Integer.parseInt(st.nextToken()));
    }
     Collections.sort(list, Collections.reverseOrder());
    for (int i = 0; i < num; i++) {
     int v = list.get(i)-(num-i);
      if(max<v){
        max = v;
      }
    }*/
    // 001 1
    // 33 34 34 32 18 8
    //bw.write(Arrays.toString(arr2));
    //bw.write(String.valueOf(arr2));
    //bw.write(String.valueOf(num+max+2));
    // dp = new int[num + 1];
    // for (int i = 2; i < num + 1; i++) {
    // dp[i] = dp[i - 1] + 1;
    // if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
    // if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
    // }
    // bw.write(String.valueOf(dp[num]));

    // close the buffer
    br.close();
    bw.close();
  }

  public static int recursion(int n, int num){
    
    if(n>num){
      //System.out.println(n);
      // return n; //틀린답. 
      return 0;
    }
    int answer = n;
    for(int i=0;i<arr.length; i++){
      answer = Math.max(answer, recursion(n*10+arr[i],num));//recursion(n+10*arr[i], num)); 무한루프 
      //System.out.println(answer);
    }
    return answer;
  }
}
