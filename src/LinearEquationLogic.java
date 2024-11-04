import java.util.Scanner;

public class LinearEquationLogic {
    public void start() {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running == true) {

            System.out.print("Enter coordinate 1: ");
            String first = scan.nextLine();

            System.out.print("Enter coordinate 2: ");
            String second = scan.nextLine();

            System.out.println();

            int x1 = Integer.parseInt(first.substring(1, first.indexOf(",")));
            int y1 = Integer.parseInt(first.substring(first.indexOf(",") + 2, first.length() - 1));
            int x2 = Integer.parseInt(second.substring(1, second.indexOf(",")));
            int y2 = Integer.parseInt(second.substring(second.indexOf(",") + 2, second.length() - 1));

            if (x1 == x2) {
                System.out.println("Those points are on a vertical line: x = " + x1);
            }
            else {
                LinearEquation liney = new LinearEquation(x1, y1, x2, y2);

                System.out.println(liney.lineInfo());
                System.out.println();
                System.out.print("Enter a value for x: ");
                double x = scan.nextDouble();
                scan.nextLine();  //
                System.out.println();
                System.out.println("The point on the line is " + liney.coordinateForX(x));
            }

            System.out.println();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            String keepRunning = scan.nextLine();
            if (keepRunning.equals("n")) {

                System.out.println("Thank you for using the slope calculator, goodbye!");
                running = false;
            }
        }
    }
}
