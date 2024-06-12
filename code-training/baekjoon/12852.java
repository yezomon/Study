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

// 12852
// 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
// X가 3으로 나누어 떨어지면, 3으로 나눈다.
// X가 2로 나누어 떨어지면, 2로 나눈다.
// 1을 뺀다.
// 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
// 첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 자연수 N이 주어진다.
// 둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 정답이 여러 가지인 경우에는 아무거나 출력한다.
public class Main {
  // static int[] dp;
  static int[] arr; //연산수
  static int[] arr2;
  public static void main(String[] args) throws Exception {
    // Input & Output stream
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;
    // int num = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    arr = new int[1000001]; //최소연산수 
    arr2 = new int[1000001]; // path
    arr[1] = 0;
    arr[2] = 1;
    arr2[1] = 0;
    arr2[2] = 1;
    for(int i = 3; i < 1000001; i++){
      if(i%3==0&&i%2==0){
        arr2[i]=arr[i/3]<arr[i/2]?i/3:i/2;
        arr[i] = Math.min(arr[i/3], arr[i/2])+1;
      }else if(i%3==0){
        arr2[i]=arr[i/3]<arr[i-1]?i/3:i-1;
        arr[i] = Math.min(arr[i/3], arr[i-1])+1;
      }else if (i%2==0){
        arr2[i]=arr[i/2]<arr[i-1]?i/2:i-1;
        arr[i] = Math.min(arr[i/2], arr[i-1])+1;
      }else {
        arr2[i]=i-1;
        arr[i] = arr[i-1]+1;
      }
    }
    bw.write(String.valueOf(arr[num])+"\n");
    bw.write(String.valueOf(num)+" ");
    int n = arr[num];
    while (n>=1) {
      bw.write(String.valueOf(arr2[num]));
      if(n!=1){
        bw.write(" ");
      }
      n--;
      num = arr2[num];
    }
    
    // int k = Integer.parseInt(st.nextToken());
    // ArrayList<Integer> arr = new ArrayList<Integer>();
    /*
    for (int j = 0; j < num; j++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      //arr = new int[n];
      Map<Long, Integer> m = new HashMap<Long, Integer>();
      Long maxNum = Long.MIN_VALUE;
      int maxVal = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        // arr[i] = Integer.parseInt(st.nextToken());
        Long v = Long.parseLong(st.nextToken());
        m.put(v, m.getOrDefault(v, 0) + 1);
        if(maxVal < m.get(v)){
          maxNum = v;
          maxVal = m.get(v);
        }
      }
      if(maxVal > n/2){bw.write(String.valueOf(maxNum)+"\n");}
      else{bw.write("SYJKGW\n");}
      //m.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }*/
    // 완탐 dp
    // int ans = recursion(0,num);
    // bw.write(String.valueOf(ans));
    /*
     * ArrayList<Integer> list = new ArrayList<Integer>();
     * int max = Integer.MIN_VALUE;
     * for (int i = 0; i < num; i++) {
     * // st = new StringTokenizer(br.readLine());
     * list.add(Integer.parseInt(st.nextToken()));
     * }
     * Collections.sort(list, Collections.reverseOrder());
     * for (int i = 0; i < num; i++) {
     * int v = list.get(i)-(num-i);
     * if(max<v){
     * max = v;
     * }
     * }
     */
    // 001 1
    // 33 34 34 32 18 8
    // bw.write(Arrays.toString(arr2));
    // bw.write(String.valueOf(arr2));
    // bw.write(String.valueOf(num+max+2));
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

  public static int recursion(int n, int num) {

    if (n > num) {
      // System.out.println(n);
      // return n; //틀린답.
      return 0;
    }
    int answer = n;
    for (int i = 0; i < arr.length; i++) {
      answer = Math.max(answer, recursion(n * 10 + arr[i], num));// recursion(n+10*arr[i], num)); 무한루프
      // System.out.println(answer);
    }
    return answer;
  }
}
