package newp;

import java.util.Scanner;
import java.util.Stack;

public class TestClass {

    public static Polygon array[];

    public static void main(String[] args) throws Exception {
        double x, y;
        int opt1 = 1;
        int opt2 = 1;
        String answer;
        Point point1, point2;
        Polygon poly1 =null;
        int count = 0;
        Stack<Point> stackP = new Stack<>();

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome!\n" +
                "In this application, you can do various actions such as creating a polygon, calculating the distance between two points etc.\n" +
                "First, you need to have at least one point (X, Y).\n" +
                "Please enter the coordinates of your first point below. Then, options will appear:\n" +
                "Enter the X value of (X, Y): ");
        x = input.nextInt();
        System.out.print("Enter the Y value of (" + x + ", Y): ");
        y = input.nextInt();
        point1 = new Point(x, y);
        System.out.print("Your first point is: " + point1.toString());


        while (true) {
            System.out.println("\n" +
                    "The following options are available for you:\n" +
                    "  1. Create a polygon\n" +
                    "  2. Add a new point\n" +
                    "  3. Remove a point\n" +
                    "  4. Calculate distance to other points\n" +
                    "  5. Print amount of your points and their coordinates\n" +
                    "  6. Reverse the points in your polygon\n" +
                    "  7. Close your polygon\n" +
                    "  8. Calculate the total length of your polygon\n" +
                    "  9. Calculate the area of your polygon\n" +
                    "  10. Concatenate with another polygon \n" +
                    "  11. Exit\n" +
                    "\n" +
                    "Your choice: ");
            int options = input.nextInt();

            switch (options) {
                case 1:
                    System.out.println("1: selected point\n" +
                            "2: new point\n" +
                            "3: stack of points\n" +
                            "4: queue of points");
                    opt2 = input.nextInt();
                    if (opt2 == 1){
                        poly1 = new Polygon(point1);
                        stackP.push(point1);
                    }else if (opt2 == 2){
                        System.out.println("x: ");
                        x = input.nextInt();
                        System.out.println("y: ");
                        y = input.nextInt();
                        point1 = new Point(x, y);
                        System.out.println("Point created:  " + point1.toString());
                        poly1 = new Polygon(point1);
                        stackP.push(point1);
                    }else if (opt2 == 3){

                    }else if (opt2 == 4){

                    }else{
                        System.out.println("Invalid input!");
                    }

                    break;
                case 2:
                    System.out.print("x: ");
                    x = input.nextDouble();
                    System.out.print("y: ");
                    y = input.nextDouble();
                    poly1.addPoint(x,y);

                    break;
                case 3:
                    //System.out.print("x: ");
                   // x = input.nextInt();
                  //  System.out.print("y: ");
                  //  y = input.nextInt();
                    poly1.removeLastPoint();
                    break;
                case 4:
                    System.out.println("enter the first point:");
                    System.out.print("x: ");
                    x = input.nextInt();
                    System.out.print("y: ");
                    y = input.nextInt();
                    point1 = new Point(x, y);

                    System.out.println("enter the second point: ");
                    System.out.print("x: ");
                    x = input.nextInt();
                    System.out.print("y: ");
                    y = input.nextInt();
                    point2 = new Point(x, y);
                    System.out.println("Distance between " + point1.toString() + " and " + point2.toString() + " is: " + Point.distance(point1, point2));

                    break;
                case 5:
                  //  assert poly1 != null;
                    //System.out.println(poly1.printArray());
                    System.out.println(poly1.toString());
                    break;
                case 6:
                        poly1.reverse();
                    break;
                case 7:
                  poly1.close();

                    break;
                case 8:
                    System.out.println( poly1.calculateTotalLength());
                    break;
                case 9:
                    System.out.println(poly1.area());
                    break;
                case 10:
                   // poly1.concatenate();
                    break;
                case 11:
                    System.exit(0);
            }
        }
    }
}
