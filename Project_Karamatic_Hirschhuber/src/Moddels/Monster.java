package Moddels;

import java.time.LocalDate;
import java.time.LocalTime;

public class Monster extends Entity {

    private String _monstername;
    private int _coinValue;
    private LocalTime _timeKilled;

    public String getMonstername(){
        return _monstername;
    }
    public void setMonstername(String monstername){
        _monstername = monstername;
    }


    public Monster(){
        this( 0, 0, 0, 0, 0, 0, 0,0 , false, "");
    }
    public Monster(int HP, int Mana, int speed, int atkspeed, int mr, int ar, int ap, int ad, boolean aggresive, String monstername){

        super(HP, Mana, speed, atkspeed, mr, ar, ap, ad, aggresive);
        this.setMonstername(monstername);
    }


    @Override
    public String toString(){

        return super.toString() + " " + this._monstername;



    }

}

