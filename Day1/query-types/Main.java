import java.util.*;

class Query {
    int type, l, r;

    public Query(int type, int l, int r) {
        this.type = type;
        this.l = l;
        this.r = r;
    }
}

public class Main {
    static int[] arr;

    public static void processQuery(Query q) {
        if (q.l < 0 || q.r >= arr.length || q.l > q.r) {
            throw new IllegalArgumentException("Invalid query range");
        }

        if (q.type == 1) {
            query1(q);
        } else if (q.type == 2) {
            System.out.println("Result: " + query2(q));
        } else {
            throw new IllegalArgumentException("Unknown query type");
        }
    }

    private static void query1(Query q) {
        int base = arr[q.l];
        for (int i = q.l; i <= q.r; i++) {
            arr[i] = (i - q.l + 1) * base;
        }
    }

    private static int query2(Query q) {
        int sum = 0;
        for (int i = q.l; i <= q.r; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Array size: ");
        int size = sc.nextInt();
        arr = new int[size];

        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Number of queries: ");
        int q = sc.nextInt();

        System.out.println("Enter queries in format: type l r");
        System.out.println("Type 1: update, Type 2: sum query");

        while (q-- > 0) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            processQuery(new Query(type, l, r));
        }

        sc.close();
    }
}