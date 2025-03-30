import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1.minimum,O(n)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("minimum is: " + min(arr, n));

        // 2.average,O(n)
        System.out.println("average is: " + avg(arr, n));

        // 3. prime or composite,O((n)^1/2)
        int num = sc.nextInt();
        boolean result = isPrime(num, 2);
        if (result) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }

        // 4.factorial,O(n)
        int fact = sc.nextInt();
        System.out.println("factorial is: " + fact(fact));

        // 5.fibonacci,O((2^n))
        int fib = sc.nextInt();
        System.out.println("fibonacci: " + fib(fib));

        // 6.power,O(n)
        int a = sc.nextInt();
        int nPower = sc.nextInt();
        System.out.println("a in power of n is: " + power(a, nPower));

        // 7.permutations,O(n!)
        sc.nextLine();
        String str = sc.nextLine();
        System.out.println("permutation of str: ");
        permutation(str, "");

        // 8.check if "s" all consists of digits,O(n)
        String digitStr = sc.nextLine();
        boolean res = checkdigits(digitStr);
        if (res) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // 9.binomial coefficient,O((2^n))
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println("binomial coefficient is: " + bin(N, K));

        // 10.gcd,O(log(n))
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println("GCD: " + GCD(A, B));
    }

    public static int min(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        return Math.min(arr[n - 1], min(arr, n - 1));
    }

    public static int avg(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        return (arr[n - 1] + (n - 1) * avg(arr, n - 1)) / n;
    }

    public static boolean isPrime(int n, int m) {
        if (n < 2)
            return false;
        if (m * m > n) //prime
            return true;
        if (n % m == 0)//false
            return false;
        return isPrime(n, m + 1);
    }

    public static int fact(int n) {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }

    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int power(int a, int n) {
        if (n == 0)
            return 1;
        return a * power(a, n - 1);
    }

    public static void permutation(String m, String prefix) {
        if (m.isEmpty()) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < m.length(); i++) {
            String rem = m.substring(0, i) + m.substring(i + 1);
            permutation(rem, prefix + m.charAt(i));
        }
    }

    public static boolean checkdigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int bin(int n, int k) {
        if (k == 0 || k == n)
            return 1;
        return bin(n - 1, k - 1) + bin(n - 1, k);
    }

    public static int GCD(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return GCD(m, n % m);
        }
    }
}