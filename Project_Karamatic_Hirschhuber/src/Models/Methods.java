package Models;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Methods {

    private Scanner reader = new Scanner(System.in);
    private List<Champion> championList;



    public void gamemenu() throws IOException {
        Path path = Paths.get("C:\\Users\\HP\\Desktop\\repositories\\Project_3BHWII_Karamatic_Hirschhuber\\Champion_Liste\\championlist.csv");
        championList = readChamps(path);

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
                                List<Champion> cList;
                                cList = readChamps(path);
                                for(Champion c: cList){
                                    System.out.println(c);
                                }
                                break;
                            case 'c':
                                // Champion erstellen
                                Champion c = createChamp();
                                boolean champNameExists = false;
                                // überprüfen, ob der Name bereits existiert
                                if(championList.size()>=1) {
                                    for (Champion ca : championList) {
                                        if (ca.getName().equals(c.getName())) {
                                            champNameExists = true;
                                        }
                                    }
                                    if(champNameExists){
                                        System.out.println("Champion existiert bereits!");
                                    }
                                    else{
                                        writeChamp(path, c);
                                        championList = readChamps(path);
                                        System.out.println("Champion wurde erzeugt");
                                    }
                                }
                                else{
                                    writeChamp(path, c);
                                    System.out.println("Champion wurde erstellt!");
                                    championList = readChamps(path);
                                }
                                // falls der NAme nicht existiert, wird er der Liste der Champs hinzugefügt

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

    public Champion createChamp() throws IOException {

        Champion c = new Champion();
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

        return c;
    }
    public void writeChamp(Path path, Champion c) throws IOException {

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
    public void writeChamps(Path path, List<Champion> cList){

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
    public List<Champion> readChamps(Path path){
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

    public double fight (Monster m, Champion c){
        boolean repatk;
        char choice;
        int maxHP = c.getHP();
        System.out.print("As you walk into the Arena you see yur enemy ");
        System.out.println(m.getMonstername());
        System.out.println("FIGHT\n");
        //System.out.println(m.toString());

        while (m.getHP() > 0 && c.getHP() > 0){

            if (m.getAtkspeed()*m.getSpeed()>c.getAtkspeed()*c.getSpeed()){

                System.out.println(m.getMonstername() + " dealt "+ (m.getAd()-m.getAr()) + "damage to you" );
                c.recive_ad_damage(m.getAd());
                c.setAtkspeed((int)Math.round(c.getAtkspeed()+10));
                if(repatk= !true){
                System.out.println(m.toString());}
                repatk =true;
                m.setAtkspeed((int)Math.round(m.getAtkspeed()-10));

            }
            else {
                c.setAtkspeed((int)Math.round(c.getAtkspeed()-10));
                repatk = false;
                System.out.println(c.getName()+":");
                System.out.println(c.toString());


                System.out.println(m.getMonstername()+":");
                System.out.println(m.toString());
                m.setAtkspeed((int)Math.round(m.getAtkspeed()+10));

                System.out.println("NO TIME TO W8!");
                System.out.println("Choose ur atack");
                System.out.println("Physical[P]");
                System.out.println("Magical[M]");
                System.out.println("Abilities[A]");
                System.out.println("RUN [R] ");
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
                    case 'A':
                       String ability = selectability_f (c);
                       if (ability == "Stunn"){}
                        else if (ability == "Heal"){if (c.getHP()+25 <= maxHP){c.setHP(c.getHP()+25);}}
                        else if (ability == "Rage"){c.setAd(c.getAd()+10);}
                        else if (ability == "Focus"){c.setAp(c.getMr()+10);}
                       else if (ability == "prepare for impact"){c.setAr(c.getAr()+10);}
                        else if (ability == "none"){}





                        break;


                    case 'R':
                        return 0;
               // System.out.println("got here");
            }

        }

    }
        if (c.getHP()!=0){return m.getCoinValue();}
        else{
            System.out.println("You fell unconcious and had to pay medical fees");
            return - 10.0;}
    }
    public String selectability_f (Champion c) {
        char choice;
        Scanner reader = new Scanner(System.in);
        System.out.println("Choose ur ability");
        System.out.println(c.getfirstAbility() + "[1]");
        System.out.println(c.getSecondAbility() + "[2]");
        choice = reader.next().toLowerCase().charAt(0);
        reader = new Scanner(System.in);
        switch (choice) {
            case '1':

                return c.getfirstAbility();



            case '2':

                return c.getSecondAbility();


            default:
                return "none";

        }

    }
    
}
