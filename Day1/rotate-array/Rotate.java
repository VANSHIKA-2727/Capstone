import java.util.*;

public class Rotate {
  private static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  private static void rotateArray(int[] arr, int k) {
    int n = arr.length;

    k = k % n;
    if (k < 0)
      k += n;

    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the size of the array: ");
    int size = sc.nextInt();
    int[] arr = new int[size];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < size; i++) {
      System.out.print("Element " + (i + 1) + ": ");
      arr[i] = sc.nextInt();
    }

    System.out.print("Enter the value of K for rotation: ");
    int k = sc.nextInt();

    rotateArray(arr, k);

    System.out.println(Arrays.toString(arr));

    sc.close();
  }
}