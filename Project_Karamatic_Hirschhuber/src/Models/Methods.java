package Models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Methods {

    static Scanner reader = new Scanner(System.in);
    List<Champion> cList;
    public static Champion createChamp() throws IOException {
        Path path = Paths.get("C:\\Users\\HP\\Desktop\\repositories\\Project_3BHWII_Karamatic_Hirschhuber\\Champion_Liste\\championlist.csv");

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
                                Path path = Paths.get("C:\\Users\\HP\\Desktop\\repositories\\Project_3BHWII_Karamatic_Hirschhuber\\Champion_Liste\\championlist.csv");
                                System.out.println("Wählen Sie Ihren Champion aus!");
                                List<Champion> cList;
                                cList = readChamps(path);
                                for(Champion c: cList){
                                    System.out.println(cList);
                                }
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

    public static List<Champion> readChamps(Path path){
        List<String> content = new ArrayList<>();
        List<Champion> cList = new ArrayList<>();
        try{
            content = Files.readAllLines(path);
        }
        catch(IOException e){
            System.out.println("Fehler beim Lesen der Champions");
        }

        for(String line : content){
            Champion c = new Champion();
            String[] parts = line.split(";");

            c.setName(parts[0]);
            c.setfirstAbility(parts[1]);
            c.setSecondAbility(parts[2]);
            c.setGold(Double.parseDouble(parts[3]));
            c.setHP(Integer.parseInt(parts[4]));
            c.setMana(Integer.parseInt(parts[5]));
            c.setAd(Integer.parseInt(parts[6]));
            c.setAp(Integer.parseInt(parts[7]));
            c.setAtkspeed(Integer.parseInt(parts[8]));
            c.setAr(Integer.parseInt(parts[9]));
            c.setMr(Integer.parseInt(parts[10]));
            c.setSpeed(Integer.parseInt(parts[11]));
            cList.add(c);
        }
        return cList;

    }
}
