import java.util.*;
public class tribo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = tribonacci(n);
        System.out.print(res);
    }
    public static 2int tribonacci(int n) {
        int arr[] = new int[38];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3; i < n + 1; i++){
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        return arr[n];
    }
}