package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Login {
    static List<Champion> CList = new ArrayList<>();
    static Champion c1 = new Champion();
    static Scanner scan;

    static {
        try {
            scan = new Scanner (new File("D:\\funn\\PROJECTS\\Project_3BHWII_Karamatic_Hirschhuber\\Champion_Liste\\login.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Scanner keyboard = new Scanner (System.in);

    public static Champion Login(Path path) throws FileNotFoundException, IndexOutOfBoundsException {


        CList = Methods.readChamps(path);
        HashMap<String, String> psw = new HashMap<String, String>();

        // Add keys and values (Country, City)
        do{
        psw.put(scan.nextLine(), scan.nextLine());}
        while(scan.hasNextLine());
        System.out.println(psw);




        //String user = scan.nextLine();
        //String pass = scan.nextLine(); // looks at selected file in scan

        System.out.println("User:");
        String inpUser = keyboard.nextLine();

        System.out.println("pass:");
        String inpPass = keyboard.nextLine(); // gets input from user

        if (inpUser.equals(inpUser) && inpPass.equals(psw.get(inpUser))) {
            System.out.print("correct login ");

            for (int i=0;  i < CList.size();i++)
            {

                c1 = CList.get(i);
                //System.out.println(c1.getName());
                //System.out.println(inpUser);
                //System.out.println(c1 + " here");

                if(c1.getName().equals(inpUser)){
                  //  System.out.println(c1 + " here1");
                return c1;}
            }

        } else {
            System.out.print("incoorect psw BZW NAME maby both WHO KNOWS");

        }
        return null;
    }
}