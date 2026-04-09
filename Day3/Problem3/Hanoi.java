package Day3.Problem3;

public class Hanoi {

    public static void main(String[] args) {
        int n = 3; // number of discs
        play(n, 'A', 'B', 'C');
    }

    static void play(int n, char source, char helper, char destination) {

        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // first recursion for (n-1) discs
        play(n - 1, source, destination, helper);

        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        play(n - 1, helper, source, destination);
    }
}