package Models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.*;
import java.util.Scanner;








public class Methods {

    static Scanner reader = new Scanner(System.in);
    public static Champion createChamp() throws IOException {
        Path path = Paths.get("D:\\funn\\PROJECTS\\Project_3BHWII_Karamatic_Hirschhuber\\Champion_Liste\\championlist.csv");

            Champion c = new Champion();
            List<Champion> championList = new ArrayList<>();
            System.out.print("Please enter Champion Name: ");
            c.setName(reader.nextLine());
            reader = new Scanner(System.in);
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

            writeChamp(path, c);
        System.out.println("Champion erstellt!");
            return c;

    }


    public static void gamemenu() throws IOException {
        char choice;
        do {
            System.out.println("");
            System.out.println("HAUPTMENÜ\n");
            System.out.println("Herzlich Willkommen!");
            System.out.println("Wie wünschen Sie fortzufahren?");
            System.out.println("PvP[G]");
            System.out.println("PvE[M]");
            System.out.println("Shop[P]");
            System.out.println("Championverwaltung[C]");
            System.out.println("Beenden[B]");
            System.out.print("Ihre Wahl: ");
            choice = reader.next().toLowerCase().charAt(0);
            reader = new Scanner(System.in);
            System.out.print("\n\n");

            switch (choice) {
                case 'g':
                    System.out.println("Spielerkampf");
                    break;

                case 'm':
                    System.out.println("Monster bekämpfen");
                    break;

                case 'p':
                    do {
                        System.out.println("SHOP \n");
                        System.out.println("AD[D]");
                        System.out.println("AP[P]");
                        System.out.println("Tank[T]");
                        System.out.println("Zurück[Z]");
                        System.out.println("Ihre Wahl: ");
                        choice = reader.next().toLowerCase().charAt(0);
                        reader = new Scanner(System.in);

                        switch (choice) {
                            case 'd':
                                System.out.println("10 AD");
                                System.out.println("20 AD");
                                System.out.println("40 AD");
                                break;
                            case 'p':
                                System.out.println("10 AP");
                                System.out.println("25 AP");
                                System.out.println("50 AP");
                                break;
                            case 't':
                                System.out.println("10 Rüstung");
                                System.out.println("20 Rüstung");
                                System.out.println("15 Magieresistenz");
                                System.out.println("30 Magieresistenz");
                                System.out.println("50 Leben");
                                System.out.println("100 Leben");
                                break;
                                        }
                        }
                        while(choice != 'z');
                        break;

                case 'c':
                    do {
                        System.out.println("CHAMPIONVERWALTUNG\n");
                        System.out.println("Champion laden[L]");
                        System.out.println("Champion erstellen[C]");
                        System.out.println("Champion löschen[D]");
                        System.out.println("Zurück[Z]");
                        System.out.print("Ihre Wahl: ");
                        choice = reader.next().toLowerCase().charAt(0);
                        reader = new Scanner(System.in);

                        switch (choice) {
                            case 'l':
                                System.out.println("Wählen Sie Ihren Champion aus!");
                                break;
                            case 'c':
                                createChamp();
                                break;
                            case 'd':
                                System.out.println("Wählen Sie Ihren Champion aus!");
                                break;
                                        }
                        }
                    while(choice != 'z');
                    break;

                case 'b':
                    System.out.println("Auf Wiedersehen!");
                    break;

                default:
                    System.out.println("Falsche Taste!");
                    break;
            }

        }
        while(choice != 'b');
    }

    public static void writeChamp(Path path, Champion c) throws IOException {

        //Article a in eine Zeichenkette umwandeln mit Strichppunkt dazwischen
        String champ = c.getName() + ";" + c.getfirstAbility() + ";" + c.getSecondAbility() + ";" + c.getGold()+ ";" +
                c.getHP() + ";" + c.getMana() + ";" + c.getAd() + ";" + c.getAp() + ";" + c.getAtkspeed() + ";" +
                c.getAr() + ";" + c.getMr() + ";" + c.getSpeed() + ";\n";
        if(Files.exists(path)){
            Files.writeString(path, champ, StandardOpenOption.APPEND);
        }
        else{
            Files.writeString(path, champ, StandardOpenOption.CREATE);
        }

    }

    public static void writeChamps(Path path, List<Champion> cList){

        try {
            Files.delete(path);

            for (Champion c : cList) {
                writeChamp(path, c);
            }
        }
        catch(IOException e){
            System.out.println("Fehler beim Hinzufügen!");
        }
    }

    public static double fight (Monster m, Champion c){
        boolean repatk;
        char choice;
        System.out.print("As you walk into the Arena you see yur enemy ");
        System.out.println(m.getMonstername());
        //System.out.println(m.toString());

        while (m.getHP() > 0 && c.getHP() > 0){

            if (m.getAtkspeed()*m.getSpeed()>c.getAtkspeed()*c.getSpeed()){

                System.out.println(m.getMonstername() + " dealt "+ m.getAd() + "damage to you" );
                c.recive_ad_damage(m.getAd());
                c.setAtkspeed((int)Math.round(c.getAtkspeed()+10));
                if(repatk= true){
                System.out.println(m.toString());}
                m.setAtkspeed((int)Math.round(m.getAtkspeed()-10));

            }
            else {
                c.setAtkspeed((int)Math.round(c.getAtkspeed()-10));
                System.out.println(c.toString());
                m.setAtkspeed((int)Math.round(m.getAtkspeed()+10));
                System.out.println("FIGHT\n");
                System.out.println("NO TIME TO W8!");
                System.out.println("Choose ur atack");
                System.out.println("physical[P]");
                System.out.println("magical[M]");
                System.out.println("RUNN [R] ");
                choice = reader.next().toLowerCase().charAt(0);
                reader = new Scanner(System.in);
                System.out.print("\n\n");
                switch (choice) {
                    case 'p':
                        System.out.println(c.getName() + " dealt physical"+ c.getAd() + "damage to " + m.getMonstername() );
                        m.recive_ad_damage(c.getAd());
                        m.setAtkspeed((int)Math.round(m.getAtkspeed()+10));
                        //System.out.println(c.toString());
                        c.setAtkspeed((int)Math.round(c.getAtkspeed()-10));
                        break;

                    case 'm':
                        System.out.println(c.getName() + " dealt magical "+ c.getAp() + "damage to " + m.getMonstername() );
                        m.recive_ap_damage(c.getAp());
                        m.setAtkspeed((int)Math.round(m.getAtkspeed()+10));
                        //System.out.println(c.toString());
                        c.setAtkspeed((int)Math.round(c.getAtkspeed()-10));
                        break;

                    case 'R':
               // System.out.println("got here");
            }

        }

    }
        if (c.getHP()!=0){return m.getCoinValue();}
        else{
            System.out.println("You fell unconcious and had to pay medical fees");
            return - 10.0;}
    }
    
}
