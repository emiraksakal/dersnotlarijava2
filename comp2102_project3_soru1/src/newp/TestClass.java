package newp;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import static newp.HashMapJava.check;

public class TestClass {


    public static void main(String[] args) {
        int option = 1;
        Scanner input = new Scanner(System.in);
        String pass;


        while (option >= 1 && option < 3) {
            System.out.println("WELCOME TO IŞIK PASSWORD CHECKER\n" +
                    "1- CHECK PASSWORD!\n" +
                    "2- EXIT!");
            option = input.nextInt();

            if (option == 1) {
                System.out.print("password: ");
                pass = input.next();
                check(pass);

            }
            if (option == 2) {
                System.exit(0);
            }
        }
    }



}
