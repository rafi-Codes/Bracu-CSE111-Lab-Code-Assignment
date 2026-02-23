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

// Task 02
import java.util.Scanner;
public class task02 {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.next();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a') System.out.print('z');
            else{
                System.out.print((char)(str.charAt(i) - 1));
            }
        }
        sc.close();
    }
}

// Task 03
import java.util.Scanner;
public class task03 {
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("N = ");
        int N = sc.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++){
            int cnt = 0;
            for (int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j] && i  > j) break;
                else if (arr[i] == arr[j]) cnt++;
            }
            if(cnt > 0) System.out.println( arr[i] + " - " + cnt + " times");
        }

        sc.close();
    }
}

// Task 04
public class CSECourse {
    public String courseName = "Programming Language II";
    public String courseCode = "CSE111";
    public int credit = 3;
}
