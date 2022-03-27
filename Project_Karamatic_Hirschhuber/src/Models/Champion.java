package Models;

public class Champion extends Entity {

    private String _name;
    private String _firstAbility;
    private String _secondAbility;
    private double gold;
    private double _winrate; //maybe so a win/loss stuff


    public String getName(){
        return _name;
    }
    public void setName(String name){
        _name = name;
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

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        if (gold >= 0) this.gold = gold;
        else System.out.println("U POOR");
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
        this( 0, 0, 0, 0, 0, 0, 0,0 ,0.0, false, "", "", "");
    }
    public Champion(int HP, int Mana, int speed, int atkspeed, int mr, int ar, int ap, int ad,double gold, boolean aggresive, String name, String firstAblity, String secondAbility){

        super(HP, Mana, speed, atkspeed, mr, ar, ap, ad, aggresive);
        this.setName(name);
        this.setfirstAbility(firstAblity);
        this.setSecondAbility(secondAbility);
        this.setGold(gold);
    }

    public double atk_prio(int atkdisadvantage){return (speed+atkspeed*1.2-atkdisadvantage);}


    @Override
    public String toString(){

        return super.toString() + " NAME: " + this._name + " GOLD : " +this.gold+""+ this._firstAbility + " " + this._secondAbility;



    }

}

