package Moddels;

public class Champion extends Entity {

    //bábilities, winrate, name
    private String _name;
    private String _qAbility;
    private String _wAbility;
    private String _eAbility;
    private String _rAbility;
    private double _winrate;

    public String getName(){
        return _name;
    }
    public void setName(String name){
        _name = name;
    }

    public String getQAbility(){
        return _qAbility;
    }
    public void setQAbility(String qAbility){
        _qAbility = qAbility;
    }

    public String getWAbility(){
        return _wAbility;
    }
    public void setWAbility(String wAbility){
        _wAbility = wAbility;
    }

    public String getEAbility(){
        return _eAbility;
    }
    public void setEAbility(String eAbility){
        _eAbility = eAbility;
    }

    public String getRAbility(){
        return _rAbility;
    }
    public void setRAbility(String rAbility){
        _rAbility = rAbility;
    }

    public double getWinrate(){
        return _winrate;
    }
    public void setWinrate(double winrate){
        if(winrate >= 0){
            _winrate = winrate;
        }
    }

    //TODO: ctors


    @Override
    public String toString(){
        return super.toString() + " " + this._name + " " + this._qAbility + " " + this._wAbility + " " + this._eAbility + " " + this._rAbility + " " + this._winrate;
    }

}

