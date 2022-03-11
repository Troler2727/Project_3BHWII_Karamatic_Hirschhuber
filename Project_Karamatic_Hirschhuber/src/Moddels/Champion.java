package Moddels;

public class Champion extends Entity {

    private String _name;
    private String _firstAbility;
    private String _secondAbility;
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

    Champion(){
        this("", "", "");
    }
    Champion(String name, String firstAblity, String secondAbility){
        this.setName(name);
        this.setfirstAbility(firstAblity);
        this.setSecondAbility(secondAbility);
    }


    @Override
    public String toString(){
        return super.toString() + " " + this._name + " " + this._firstAbility + " " + this._secondAbility;
    }

}

