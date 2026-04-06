import java.util.Scanner;

interface UPI {
  default void processPayment() {
    System.out.println("Payment completed using UPI");
  }
}

interface Card {
  default void processPayment() {
    System.out.println("Payment completed using card");
  }
}

class PaymentSystem implements UPI, Card {
  Scanner sc = new Scanner(System.in);

  public void processPayment() {
    System.out.println("Choose Payment Method:-");
    System.out.println("Choice 1: UPI");
    System.out.println("Choice 2: Card");
    System.out.print("\nEnter your choice: ");

    int choice = sc.nextInt();

    if (choice == 1) {
      UPI.super.processPayment();
    } else if (choice == 2) {
      Card.super.processPayment();
    } else {
      System.out.println("Invalid Choice");
    }
  }
}

public class PaymentGateway {
  public static void main(String[] args) {
    PaymentSystem system = new PaymentSystem();
    system.processPayment();
  }
}
