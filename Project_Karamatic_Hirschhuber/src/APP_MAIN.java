import Models.Champion;
import Models.Entity;
import Models.Methods;
import Models.Monster;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;

public class APP_MAIN {

    public static void main(String[] args) throws IOException {
        // public Entity(int HP,int Mana,int speed, int atkspeed,int mr,int ar, int ap,int ad,boolean aggresive)
        //Entity e1 = new Entity(100, 100, 100,100,10,10, 10,10,false);
        //Entity e2 = new Entity(100, 100, 100,100,10,10, 10,20,false);
        //Monster m1 = new Monster(100, 10, 100, 1, 0, 0, 10, 10 , false, "PEDA", 10.0, LocalTime.now());
        //Champion c1 = Methods.createChamp();
        //double gold = Methods.fight(m1,c1);
        //System.out.println(gold);
        //Path path = Paths.get("D:\\funn\\PROJECTS\\Project_3BHWII_Karamatic_Hirschhuber\\Champion_Liste\\championlist.csv");


        //System.out.println(e1);
       // e1.recive_ad_damage(20); works
       // e1.recive_ap_damage(20); works
       // e2.atack_entity_ad(); works
        // e1.heal(10);

        //System.out.println(e1);

        Methods m = new Methods();

        m.gamemenu();



    }
    



}
