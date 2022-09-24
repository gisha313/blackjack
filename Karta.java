package blackjack;

public class Karta {
    private String znak;
    private int vrednost, kvantitet;

    public Karta (String z, int v, int k){
        this.znak = z;
        this.vrednost = v;
        this.kvantitet = k;
    }

    public String getZnak(){
        return this.znak;
    }

    public int getVrednost(){
        return this.vrednost;
    }

    public int getKvantitet(){
        return this.kvantitet;
    }

    public void smanji(){
        this.kvantitet -= 1;
    }
}
