package newp;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapJava {

    public static void check(String s) {
        HashMap<String, String> words = new HashMap<String, String>();
        HashMap<String, String> wordsMost = new HashMap<String, String>();

        try {
            File myobject = new File("C:\\Users\\emira\\Desktop\\wordsconverted.txt");
            Scanner myReader = new Scanner(myobject);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] stringArray = data.split(" ");
                words.put(stringArray[0], stringArray[1]);
            }
            myReader.close();
        } catch (Exception e) {
        }


        try {
            File myobject2 = new File("C:\\Users\\emira\\Desktop\\mostcommonpasswordsconverted.txt");
            Scanner myReader2 = new Scanner(myobject2);

            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                String[] stringArray2 = data.split(" ");
                wordsMost.put(stringArray2[0], stringArray2[1]);
            }
            myReader2.close();
        } catch (Exception e) {
        }

        System.out.println("---------------------");


        if (s.length() < 5) {
            System.out.println("password isn't strong. //length i 5 ten kısa");
            System.out.println(); }

        else if (words.containsValue(s) || wordsMost.containsValue(s)) {
            System.out.println("password isn't strong // txt lerde bulunuyor");
            System.out.println(); }



        else if (!words.containsValue(s) || !wordsMost.containsValue(s)) {
            int j=0;
            int x=s.length();
            String sub1 = s.substring(0);
            String sub2 = s.substring(0);

            while ( (!words.containsValue(sub1) || !wordsMost.containsValue(sub1) ||!words.containsValue(sub2) || !wordsMost.containsValue(sub2) ) ) {
                sub1 = s.substring(j,s.length());
                 sub2 = s.substring(0,x);
                x--;
                j++;
                if (x==0 || j==s.length()) break;
            }
            if (words.containsValue(sub1) || wordsMost.containsValue(sub1) || words.containsValue(sub2) || wordsMost.containsValue(sub2)) {
                int i = 0;
                while (i < 10) {
                    String ss = String.valueOf(i);
                    if (s.endsWith(ss) || s.startsWith(ss)) {
                        System.out.println("password isn't strong // başta ya da sonra sayı bulunduruyor ve txt den bir string");
                        System.out.println();

                        break;
                    } else {
                        i++;
                        if (i == 9) {
                            System.out.println("password is strong");
                        }
                    }
                }

                System.out.println();
            }
            else {System.out.println("password is strong");}


        }
    }
}

// rakamla başla kelime ile devam et rakam ile bitmeyi kontrol etmedik.
//1234564789798465 sadece sayılar varsa
 /*for (int i = 0; i < 10; i++) {
                String ss = String.valueOf(i);
                if (s.endsWith(ss) || s.startsWith(ss)) {
                    System.out.println("password isn't strong");

                } else {
                    System.out.println("password is strong");

                }
            }*/