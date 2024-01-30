import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // System.out.println(sum(5));

        // findPrimes(20);

        // System.out.println(findCountCombos(9));

        // long start = System.currentTimeMillis();
        // System.out.println(findCountCombos1(12, 6, 0));
        // long over = System.currentTimeMillis();

        // System.out.println(over - start);

        long start = System.currentTimeMillis();
        findFib(56);
        long over = System.currentTimeMillis();
        System.out.println(over - start);

        start = System.currentTimeMillis();
        findFibRec(56);
        over = System.currentTimeMillis();
        System.out.println(over - start);
    }

    public static int sum(int n) {
        int res = 0;

        for (int i = 1; i <= n; res += i, i++);

        return res;
    }

    public static void findPrimes(int n) {
        for (int i = 1; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                System.out.println(i);
        }
    }

    public static int findCountCombos(int n){
        //4 кубика n граней
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < n; l++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static long findCountCombos1(int k, int n, long count){
        //k кубика n граней
        // 6 6 0
        if (k == 0) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += findCountCombos1(k - 1, n, count + i);
        }

        return sum;
    }

    public static int findFib(int n){
        List<Integer> res = new ArrayList<>();
        res.add(1); //****
        res.add(1); //****
        for (int i = 2; i < n; i++) {
            res.add(res.get(i - 1) + res.get(i - 2));
        }

        return res.get(res.size() - 1);
    }

    public static int findFibRec(int n){
        if(n == 1 || n == 2) //****
        {
            return 1;
        }

        return findFibRec(n - 1) + findFibRec(n - 2);
    }
}