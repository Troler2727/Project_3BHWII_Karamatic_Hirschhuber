package Models;
import Methods.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Login {
    public void run() throws FileNotFoundException {

        Scanner scan = new Scanner (new File("D:\\funn\\PROJECTS\\Project_3BHWII_Karamatic_Hirschhuber\\Champion_Liste\\login.txt"));
        Scanner keyboard = new Scanner (System.in);

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
            System.out.print("your login message");
        } else {
            System.out.print("incoorect psw BZW NAME maby both WHO KNOWS");
        }
    }
}