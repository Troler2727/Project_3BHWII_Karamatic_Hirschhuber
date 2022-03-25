package Moddels;

import java.util.Scanner;

public class METHODS {
    static Scanner reader = new Scanner(System.in);
//int HP, int Mana, int speed, int atkspeed, int mr, int ar, int ap, int ad, boolean aggresive, String name, String firstAblity, String secondAbility
    public Champion create_champ() {
        Champion c = new Champion();
        System.out.println("Please enter Champion Name:");
        c.setName(reader.nextLine());
        c.setHP(100);
        c.setMana(100);
        c.setSpeed(20);
        c.setAtkspeed(20);
        c.setMr(5);
        c.setAr(5);
        c.setAp(0);
        c.setAd(20);
        c.setGold(100.00);
        c.setAggresive(false);
        c.setfirstAbility("");
        c.setSecondAbility("");




        return c;
    }


    public static void gamemenu(){
        char choice;
        System.out.println("Herzlich Willkommen!");
        System.out.println("Wie wünschen Sie fortzufahren?");
        System.out.println("PvP[G]");
        System.out.println("PvE[M]");
        System.out.println("Shop[P]");
        System.out.println("Championverwaltung[C]");
        System.out.println("Beenden[B]");
        System.out.print("Ihre Wahl: ");
        choice = reader.next().toLowerCase().charAt(0);

        switch(choice){
            case 'G':

                break;

            case 'M':

                break;

            case 'P':

                break;

            case 'C':

                break;

            case 'B':
                System.out.println("Auf Wiedersehen!");
                break;
        }
    }
}
