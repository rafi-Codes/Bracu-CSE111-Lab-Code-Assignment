// Task 01
import java.util.Scanner;
public class task01 {

    public static boolean isPrime (int n){
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        int low = sc.nextInt();
        int up = sc.nextInt();

        if (low > up){
            int temp = low;
            low = up;
            up = temp;
        }

        int cnt = 0;
        for (int i = low + 1; i < up; i++){
            if (isPrime(i)) cnt++;
        }
        System.out.println("There are "+ cnt +" prime numbers between "+ low +" and "+ up +".");
        sc.close();
    }
}
