package Moddels;

public class Champion extends Entity {

    //bábilities, winrate, name
    private String _name;
    private String _atk1;
    private String _atk2;
    private String _ability1;
    private String _ability2;
    private int HP;
    private int Mana;
    private int armor;


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




    //TODO: ctors


    @Override
    public String toString(){
        return super.toString() + " " + this._name + " " + this._atk1 + " " + this._atk2 + " " + this._ability1 + " " + this._ability2;
    }

}

