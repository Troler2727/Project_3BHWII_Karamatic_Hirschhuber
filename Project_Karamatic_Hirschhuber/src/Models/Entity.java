package Models;

public class Entity {
   int HP, Mana, speed, atkspeed, mr, ar, ap, ad;
   boolean aggresive;

    public int getHP() {
        return HP;
    }
    public int getMana() {
        return Mana;
    }
    public int getSpeed() {
        return speed;
    }
    public int getAtkspeed() {
        return atkspeed;
    }
    public int getMr() {
        return mr;
    }
    public int getAr() {
        return ar;
    }
    public int getAp() {
        return ap;
    }
    public int getAd() {
        return ad;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setMana(int mana) {
        Mana = mana;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setAtkspeed(int atkspeed) {
        this.atkspeed = atkspeed;
    }
    public void setMr(int mr) {
        this.mr = mr;
    }
    public void setAr(int ar) {
        this.ar = ar;
    }
    public void setAd(int ad) {
        this.ad = ad;
    }
    public void setAp(int ap) {
        this.ap = ap;
    }
    public void setAggresive(boolean aggresive) {
        this.aggresive = aggresive;
    }

    public Entity(){
        this(0,0,0,0,0,0,0,0,false);
    }
    public Entity(int HP,int Mana,int speed, int atkspeed,int mr,int ar, int ap,int ad,boolean aggresive) {
        this.setHP(HP);
        this.setMana(Mana);
        this.setSpeed(speed);
        this.setAtkspeed(atkspeed);
        this.setMr(mr);
        this.setAr(ar);
        this.setAp(ap);
        this.setAd(ad);
        this.setAggresive(aggresive);
    }

    public void recive_ad_damage (int damage) {
        int damage_after_calc;
        // calc damage
        damage_after_calc = damage - ar ;

        if (damage_after_calc <= 0){
            System.out.println("to tanky");
        }
        else {
            HP = HP - damage_after_calc;
        }

    }

    public void recive_ap_damage (int damage) {
        int damage_after_calc;
        // calc damage
        damage_after_calc = damage - mr ;

        if (damage_after_calc <= 0){
            System.out.println("to tanky");
        }
        else {
            HP = HP - damage_after_calc;
        }

    }

    public void heal (int heal) {
        HP = HP + heal ;
    }



    @Override
    public String toString() {
        return "HP:" +HP + " MP: " + Mana + " SPEED: " + speed + " ATKSPEED: " +
                atkspeed + "  MR: " + mr + " AR: " + ar + " AP: " + ap+"  AD:"+ ad + " aggresive: "+aggresive;
    }


}
