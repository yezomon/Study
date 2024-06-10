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

// 1270
public class Main {
  // static int[] dp;
  static int[] arr;

  public static void main(String[] args) throws Exception {
    // Input & Output stream
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;
    // int num = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    // int k = Integer.parseInt(st.nextToken());
    // ArrayList<Integer> arr = new ArrayList<Integer>();

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

    }
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

}
