//sort a stack using another stack 
//sort the stack in ascending order using another temp stack 
//for stack ascending order = 5,4,3,2,1 (top to bottom)
package Day2.Problem1;
import java.util.Stack;

public class SortStackUsingTemp {

    public static void sortStack(Stack<Integer> s) {
        Stack<Integer> temp = new Stack<>();
       //loop run until original stack is empty
        while (!s.isEmpty()) {
            int curr = s.pop();

            // Move elements back to original stack if they are greater
            while (!temp.isEmpty() && temp.peek() < curr) {
                s.push(temp.pop());
            }

            temp.push(curr);
        }

        // Optional: transfer back to original stack
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(34);
        s.push(3);
        s.push(31);
        s.push(98);
        s.push(92);
        s.push(23);

        sortStack(s);

        // Print sorted stack
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}