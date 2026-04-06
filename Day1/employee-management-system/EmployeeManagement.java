interface EmailNotification {
  default void notifyEmployee() {
    System.out.println("Sending notifications via Email");
  }
}

interface SMSNotification {
  default void notifyEmployee() {
    System.out.println("Sending notifications via SMS");
  }
}

class Notification implements EmailNotification, SMSNotification {
  public void notifyEmployee() {
    EmailNotification.super.notifyEmployee();
    SMSNotification.super.notifyEmployee();
  }
}

public class EmployeeManagement {
  public static void main(String[] args) {
    Notification notification = new Notification();

    notification.notifyEmployee();
  }
}
