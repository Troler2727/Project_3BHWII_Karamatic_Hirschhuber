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
        c.setAtkspeed();




        return c;
    }
}
