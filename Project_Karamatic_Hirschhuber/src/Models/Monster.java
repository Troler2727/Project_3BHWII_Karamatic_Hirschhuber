package Models;

import java.time.LocalTime;
import java.util.Random;

public class Monster extends Entity {

    private String _monstername;
    private double _coinValue;
    private LocalTime _timeKilled;

    public String getMonstername(){
        return _monstername;
    }
    public void setMonstername(String monstername){
        _monstername = monstername;
    }

    public double getCoinValue(){
        Random rand = new Random();
        return _coinValue*(rand.nextInt((12 - 8) + 1) + 8)/10;
    }
    public void setCoinValue(double coinValue){
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
        this( 0, 0, 0, 0, 0, 0, 0,0 , false, "", 0.0, LocalTime.now());
    }
    public Monster(int HP, int Mana, int speed, int atkspeed, int mr, int ar, int ap, int ad, boolean aggresive, String monstername, double coinValue, LocalTime timeKilled){

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

