package Moddels;

import java.time.LocalDate;

public class Champion extends Entity {

    private String _name;

    private String _atk1;
    private String _atk2;
    private String _ability1;
    private String _ability2;
    private int HP;
    private int Mana;
    private int armor;


    private String _firstAbility;
    private String _secondAbility;
    private double _winrate; //maybe so a win/loss stuff


    public String getName(){
        return _name;
    }
    public void setName(String name){
        _name = name;
    }


    public String getAtk1(){
        return _atk1;
    }
    public void setAtk1 (String atk1){
        _atk1 = atk1;
    }

    public String getAtk2(){
        return _atk1;
    }
    public void setAtk2 (String atk2){
        _atk1 = atk2;
    }

    public String getEAbility(){
        return _ability1;
    }
    public void setEAbility(String eAbility){
        _ability1 = eAbility;
    }

    public String getRAbility(){
        return _ability2;
    }
    public void setRAbility(String rAbility){
        _ability2 = rAbility;
    }




    public String getfirstAbility(){
        return _firstAbility;
    }
    public void setfirstAbility(String firstAbility){
        _firstAbility = firstAbility;
    }

    public String getSecondAbility(){
        return _secondAbility;
    }
    public void setSecondAbility(String secondAbility) {
        _secondAbility = secondAbility;
    }

    /*
    public double getWinrate(){
        return _winrate;
    }
    public void setWinrate(double winrate){
        if(winrate >= 0){
            _winrate = winrate;
        }
    }
     */


    public Champion(){
        this( 0, 0, 0, 0, 0, 0, 0,0 , false, "", "", "");
    }
    public Champion(int HP, int Mana, int speed, int atkspeed, int mr, int ar, int ap, int ad, boolean aggresive, String name, String firstAblity, String secondAbility){

        super(HP, Mana, speed, atkspeed, mr, ar, ap, ad, aggresive);
        this.setName(name);
        this.setfirstAbility(firstAblity);
        this.setSecondAbility(secondAbility);
    }


    @Override
    public String toString(){

        return super.toString() + " " + this._name + " " + this._atk1 + " " + this._atk2 + " " + this._ability1 + " " + this._ability2;



    }

}

