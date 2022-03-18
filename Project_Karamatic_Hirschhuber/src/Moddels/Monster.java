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

    public int getCoinValue(){
        return _coinValue;
    }
    public void setCoinValue(int coinValue){
        if(coinValue > 0){
            _coinValue = coinValue;
        }
    }

    public LocalTime getTimeKilled(){
        return _timeKilled;
    }
    public void setTimeKilled(LocalTime timeKilled){
        this._timeKilled = timeKilled;
    }


    public Monster(){
        this( 0, 0, 0, 0, 0, 0, 0,0 , false, "", 0, LocalTime.now());
    }
    public Monster(int HP, int Mana, int speed, int atkspeed, int mr, int ar, int ap, int ad, boolean aggresive, String monstername, int coinValue, LocalTime timeKilled){

        super(HP, Mana, speed, atkspeed, mr, ar, ap, ad, aggresive);
        this.setMonstername(monstername);
        this.setCoinValue(coinValue);
        this.setTimeKilled(timeKilled);
    }


    @Override
    public String toString(){

        return super.toString() + " " + this._monstername + " " + this._coinValue + " " + this._timeKilled;



    }

}

