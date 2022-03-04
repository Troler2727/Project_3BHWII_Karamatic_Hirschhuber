package Models;

public class decrypter {
    public char idk = 'a';

    public char getIdk() {
        return idk;
    }

    public void setIdk(char idk) {
        this.idk = idk;
    }

    public decrypter(){
        this('_');
    }
    public decrypter(char idk) {
    this.setIdk(idk);
    }

    @Override
    public String toString() {
        return idk + " " ;
    }
}
