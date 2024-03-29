/* Program Name: StackMath
 * Program Purpose: Evaluate equations using the Stack class and postfix expressions
 * Created / Edited by: jramrez
 */

 import java.util.*;

 public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Double> stacker = new Stack<Double>(); 

        System.out.println("Enter a math equation as a POSTFIX expression (e.g. 5 8 +):");
        String inpt = scan.nextLine(); //prompt and scan
        Scanner inptScan = new Scanner(inpt); //scans the input itself 
        inptScan.useDelimiter(" ");  //this separates the numbers and operators as the scanner reads up to a space, allowing for 2+ digit numbers

        for (int count = 0; count <= numSpaces(inpt); count++) { // for loop keeps the function in check
            String current = inptScan.next();  // scanner of the input in use
            if (ifOperator(current)) { // if the current section of the string is an operator, it does this
                stacker.push(returnResult(current, stacker.pop(), stacker.pop()));
            }
            else { // otherwise it parses it and pushes it in the stack
                stacker.push(Double.parseDouble(current));
            }
        }
        System.out.println(stacker.peek());
        scan.close();
        inptScan.close();
    }




    // the following are functions for the main 
    public static boolean ifOperator(String s) {
        String[] oparray = {"+","-","*","/","%"};

        for (String p : oparray) {
            if (s.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public static double returnResult(String s, double num2, double num1) {  
        switch (s) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            case "%":
                return num1 % num2;
            default:
                return -1;
        }
    }
    
    public static int numSpaces(String s) {
        int count = 0;
        int last = 0;
        while (last != -1) {
            last = (s.indexOf(" ", last + 1));
            if (last != -1) {
                count++;
            }
            last = (s.indexOf(" ", last + 1));
        }
        return count;
    }
}