import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        
        for (int i = 0; i < word.length(); i += 10) {
            System.out.println(word.substring(i, Math.min(i + 10, word.length())));
        }
        
        scanner.close();
    }
}
